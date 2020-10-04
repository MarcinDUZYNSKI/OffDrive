package pl.pojechali.offdrive.DbFile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.pojechali.offdrive.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = GpxFile.TABLE)
@Getter @Setter @ToString(exclude = "data")
@EqualsAndHashCode(of = "id")
public class GpxFile {
    public static final String TABLE = "gpx_file";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String originalFileName;
    @Column(name = "content_type", nullable = false)
    private String contentType;
    private Long size;
    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)  // ładowanie lazy żę nie pobierać wszystkich opcional = false to infirmacje że dane nie mogą być nullem
    @Column(nullable = false, columnDefinition = "MEDIUMBLOB") // zapis go przechowywanie dużych plików do 16MB
    private byte[] data; // alternatywnie można przechowyać scieżkę do pliku

    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;
    @ManyToOne
    private User user;

    @PrePersist
    public void prePrersist(){



    }
}
