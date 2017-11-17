package training.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import training.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Vasya", "Petrov",
            "Petrovich", "tester.1123", "+7(343)00-00-00", "+7(900)949-04-04",
            "8-800-000-00-00", "tester1@rrr.com", "tester2@gmail.com",
            "tester@666.ru", "http://localhost","[none]");
    app.getContactHelper().createContact(contact, true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
