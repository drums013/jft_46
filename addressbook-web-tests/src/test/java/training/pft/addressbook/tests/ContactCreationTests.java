package training.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import training.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstname("Vasya").withMiddlename("Petrov").withLastname("Petrovich")
            .withNick("tester.1123").withHomephone("+7(343)00-00-00").withMobilephone("+7(900)949-04-04")
            .withWorkphone("8-800-000-00-00").withFirstmail("tester1@rrr.com").withSecondmail("tester2@gmail.com")
            .withFirdmail("tester@666.ru").withUserhomepage("http://localhost").withGroup("[none]");
    app.contact().create(contact, true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
