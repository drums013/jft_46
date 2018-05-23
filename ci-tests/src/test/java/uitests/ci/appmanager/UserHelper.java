package uitests.ci.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

  private String user;
  private String password;

  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String user, String password) {
    this.user = user;
    this.password = password;
    type(By.name("login"), user);
    type(By.name("password"),password);
    click(By.cssSelector("button.btn"));
  }
}
