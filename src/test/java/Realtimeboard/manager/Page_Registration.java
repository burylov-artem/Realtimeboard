package Realtimeboard.manager;

public class Page_Registration {
  private final String username;
  private final String userpassword;
  private final String usermail;

  public Page_Registration(String username, String usermail, String userpassword) {
    this.username = username;
    this.usermail = usermail;
    this.userpassword = userpassword;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return usermail;
  }

  public String getUserpassword() {
    return userpassword;
  }
}
