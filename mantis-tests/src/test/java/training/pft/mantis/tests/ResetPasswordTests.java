package training.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import training.pft.mantis.model.MailMessage;
import training.pft.mantis.model.UserData;
import training.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void resetPasswordTest() throws IOException, MessagingException {
    app.getDriver();
    app.user().login("administrator", "root");
    Users listOfUsers  = app.db().users();
    UserData selectedUser = listOfUsers.iterator().next();
    String username = selectedUser.getUsername();
    String email = username + "@localhost";
    app.user().resetPassword(username);
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 60000);
    String confirmationLinkReset = findConfirmationLink(mailMessages, email);
    String newpass = "newpass";
    app.user().finish(confirmationLinkReset, newpass);
    assertTrue(app.newSession().login(username,newpass));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
