package uitests.ci.tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

  @Test
  public void testLogin() {
    app.user().login("i.", "123");
  }
}
