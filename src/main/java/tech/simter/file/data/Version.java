package tech.simter.file.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

/**
 * The application deployment information about git repository.
 *
 * @author RJ
 */
@Configuration
@PropertySource("classpath:git.properties")
@ConfigurationProperties(prefix = "git")
public class Version implements Serializable {
  private String branch;
  @Value("${git.build.time}")
  private String buildTime;
  @Value("${git.build.version}")
  private String buildVersion;
  @Value("${git.build.user.name}")
  private String buildUserName;
  @Value("${git.build.user.email}")
  private String buildUserEmail;
  @Value("${git.commit.id}")
  private String commitId;
  @Value("${git.commit.time}")
  private String commitTime;
  @Value("${git.commit.user.name}")
  private String commitUserName;
  @Value("${git.commit.user.email}")
  private String commitUserEmail;
  @Value("${git.remote.origin.url}")
  private String url;

  public Version() {
  }

  public Version(Version version) {
    this.copy(version);
  }

  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public String getBuildTime() {
    return buildTime;
  }

  public void setBuildTime(String buildTime) {
    this.buildTime = buildTime;
  }

  public String getBuildVersion() {
    return buildVersion;
  }

  public void setBuildVersion(String buildVersion) {
    this.buildVersion = buildVersion;
  }

  public String getCommitId() {
    return commitId;
  }

  public void setCommitId(String commitId) {
    this.commitId = commitId;
  }

  public String getCommitUserName() {
    return commitUserName;
  }

  public void setCommitUserName(String commitUserName) {
    this.commitUserName = commitUserName;
  }

  public String getCommitUserEmail() {
    return commitUserEmail;
  }

  public void setCommitUserEmail(String commitUserEmail) {
    this.commitUserEmail = commitUserEmail;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getBuildUserName() {
    return buildUserName;
  }

  public void setBuildUserName(String buildUserName) {
    this.buildUserName = buildUserName;
  }

  public String getBuildUserEmail() {
    return buildUserEmail;
  }

  public void setBuildUserEmail(String buildUserEmail) {
    this.buildUserEmail = buildUserEmail;
  }

  public String getCommitTime() {
    return commitTime;
  }

  public void setCommitTime(String commitTime) {
    this.commitTime = commitTime;
  }

  public void copy(Version version) {
    this.branch = version.getBranch();
    this.buildTime = version.getBuildTime();
    this.buildVersion = version.getBuildVersion();
    this.buildUserEmail = version.getBuildUserEmail();
    this.buildUserName = version.getBuildUserName();
    this.commitId = version.getCommitId();
    this.commitTime = version.getCommitTime();
    this.commitUserEmail = version.getCommitUserEmail();
    this.commitUserName = version.getCommitUserName();
    this.url = version.getUrl();
  }
}