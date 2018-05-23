package uitests.ci.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final Properties properties;
  private WebDriver wd;

  private String browser;
  private UserHelper userHelper;
  private DbHelper dbHelper;

  public ApplicationManager(String browser){
    this.browser = browser;
    properties = new Properties();

  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

  public WebDriver getDriver() {
    if (wd == null){
      if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
      } else if (browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      }

      wd.get(properties.getProperty("web.baseUrl"));
      wd.manage().window().setSize(new Dimension(1920, 1080));
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    return wd;
  }

  public UserHelper user() {
    if (userHelper == null) {
      userHelper = new UserHelper(this);
    }
    return userHelper;
  }

  public DbHelper db() {
    return dbHelper;
  }
}
