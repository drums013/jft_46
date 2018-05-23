package training.pft.mantis.tests;

import org.testng.annotations.Test;
import training.pft.mantis.appmaneger.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {

  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login(app.getProperty("web.userLogin"), app.getProperty("web.userPassword")));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
