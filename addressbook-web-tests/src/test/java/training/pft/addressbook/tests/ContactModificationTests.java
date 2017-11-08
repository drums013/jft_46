package training.pft.addressbook.tests;

import org.testng.annotations.Test;
import training.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillOutContactDetails(new ContactData("Vasya", "Petrov", "Petrovich", "tester.1123", "+7(343)00-00-00", "+7(900)949-04-04", "8-800-000-00-00", "tester1@rrr.com", "tester2@gmail.com", "tester@666.ru", "http://localhost", null),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
