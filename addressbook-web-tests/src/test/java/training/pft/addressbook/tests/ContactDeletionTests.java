package training.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import training.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Vasya").withMiddlename("Petrov").withLastname("Petrovich")
              .withNick("tester.1123").withHomephone("+7(343)00-00-00").withMobilephone("+7(900)949-04-04")
              .withWorkphone("8-800-000-00-00").withFirstmail("tester1@rrr.com").withSecondmail("tester2@gmail.com")
              .withFirdmail("tester@666.ru").withUserhomepage("http://localhost").withGroup("[none]"), true);
    }
  }

  @Test
  public void testContactDeletion() {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }

}
