package pl.pojechali.offdrive.DbFile;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/files")
@RequiredArgsConstructor
public class GpsFileUploadController {
    private final GpxFileRepository gpxFileRepository;

    @GetMapping
    public  String prepareFilesPage(Model model){
        model.addAttribute("files", gpxFileRepository.findAll()); //zwracamy wszystkie pliki co raczej jest głupotą bo zabijemy bazę i transfer danych ;)
        return "files";
    }

    /**
     * metoda do wyświetlania zapisanych plików -> w tym przypadku raczaj nieprzydatne bo przeglądarka nie wyświetli GPX no chyba żę jakać mapa da radę
     * @param id
     * @return
     */
    @GetMapping("/{id:[\\d+]")
    public ResponseEntity<Resource> getFile(@PathVariable Long id){
        GpxFile gpxFile = gpxFileRepository.findWithDataById(id); // poprawione żęby nie waliło błędem
        ByteArrayResource resource = new ByteArrayResource(gpxFile.getData()); // data jest lazy czyli wywali błąd
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(gpxFile.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, //
                        "INLINE; FILENAME=\"" + gpxFile.getFileName() + "\"")  // nie inline tylka atachment jeżeli ma być lista do pobrania
                .body(resource);
    }

    @GetMapping("/upload")
    public String prepareUploadFile(){
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadGpxFile(@RequestPart (name = "file") MultipartFile file,
                                @RequestParam (required = false) String fileName) throws IOException {  //requestPart jest bardziej precyzyjne niż requestParam bo pliki są rzesyłąne w żądaniu w kawałchach
        GpxFile gpxFile = new GpxFile();
        gpxFile.setContentType(file.getContentType());
        gpxFile.setSize(file.getSize());
        gpxFile.setOriginalFileName(file.getOriginalFilename());
        gpxFile.setData(file.getBytes());

        gpxFile.setFileName(fileName); // dorobiliśmy nazwę pliku zapisaną przez usera

        gpxFileRepository.save(gpxFile);
        return String.valueOf(gpxFile.getId());
    }
}
