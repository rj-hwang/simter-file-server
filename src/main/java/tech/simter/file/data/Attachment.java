package tech.simter.file.data;

/**
 * The uploaded file information.
 *
 * @author RJ
 */
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Attachment {
  private Long id;
  private String name;
  private String ext;
  private Long size;
  private String path;

  public Attachment(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getExt() {
    return ext;
  }

  public void setExt(String ext) {
    this.ext = ext;
  }

  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}