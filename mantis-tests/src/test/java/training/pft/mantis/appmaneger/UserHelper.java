package training.pft.mantis.appmaneger;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

  private String user;
  private String password;
  private String username;

  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String user, String password){
    this.user = user;
    this.password = password;
    type(By.name("username"), user);
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
  }

  public void resetPassword(String user) {
    this.username = user;
    click(By.linkText("Manage"));
    click(By.linkText("Manage Users"));
    click(By.linkText(username));
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public void finish(String confirmationLinkReset, String newpass) {
    wd.get(confirmationLinkReset);
    type(By.name("password"),newpass);
    type(By.name("password_confirm"),newpass);
    click((By.cssSelector("input[value='Update User']")));
  }
}
