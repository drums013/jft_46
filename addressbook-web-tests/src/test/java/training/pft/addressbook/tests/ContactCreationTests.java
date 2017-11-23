package training.pft.addressbook.tests;

import org.testng.annotations.Test;
import training.pft.addressbook.model.ContactData;
import training.pft.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Vasya").withMiddlename("Petrov").withLastname("Petrovich")
            .withNick("tester.1123").withHomephone("+7(343)00-00-00").withMobilephone("+7(900)949-04-04")
            .withWorkphone("8-800-000-00-00").withFirstmail("tester1@rrr.com").withSecondmail("tester2@gmail.com")
            .withFirdmail("tester@666.ru").withUserhomepage("http://localhost").withGroup("[none]");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact
            .withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
