package pl.pojechali.offdrive.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import pl.pojechali.offdrive.file.DbFile;
import pl.pojechali.offdrive.file.DbFileRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/upload")
public class FileResourceController {

  private final DbFileRepository dbFileRepository;

  @PostMapping
  public String uploadFile(@RequestPart MultipartFile file) {
    DbFile dbFile = new DbFile();
    dbFile.setContentType(file.getContentType());
    dbFile.setSize(file.getSize());
    dbFile.setOriginalFileName(file.getOriginalFilename());
    // reszta analogicznie
    dbFileRepository.save(dbFile);
    return String.valueOf(dbFile.getId());
  }
}
