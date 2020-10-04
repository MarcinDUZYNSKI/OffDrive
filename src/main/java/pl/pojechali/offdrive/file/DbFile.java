package pl.pojechali.offdrive.file;

import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "files")
@Getter
@Setter
@ToString(exclude = "data") // nie używamy pola data!
@EqualsAndHashCode(of = "id")
public class DbFile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "file_name", nullable = false)
  private String fileName;
  @Column(name = "original_file_name")
  private String originalFileName;
  @Column(name = "content_type", nullable = false)
  private String contentType;
  private long size;
  @Lob
//  ważne przy wyciąganiu danych dla zapytania tu jest lazy
  @Basic(fetch = FetchType.LAZY, optional = false)
  @Column(nullable = false, columnDefinition = "MEDIUMBLOB")
//  można rzechowywać ściezkę zamiast pliku
  private byte[] data;

  @Column(name = "created_on", updatable = false)
  private LocalDateTime createdOn;

  @PrePersist
  public void prePersist() {
    createdOn = LocalDateTime.now();
  }
}
