package training.pft.addressbook.tests;

import org.testng.annotations.Test;
import training.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().gotoAddContactPage();
    app.getContactHelper().fillOutContactDetails(new ContactData("Vasya", "Petrov",
            "Petrovich", "tester.1123", "+7(343)00-00-00", "+7(900)949-04-04",
            "8-800-000-00-00", "tester1@rrr.com", "tester2@gmail.com",
            "tester@666.ru", "http://localhost", "test1"), true);
    app.getContactHelper().submitContactDetails();
    app.getContactHelper().returnToHomePage();
  }

}
