package training.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import training.pft.addressbook.model.ContactData;
import training.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/test.png");
    list.add(new Object[] {new ContactData().withFirstname("Vasya 1").withMiddlename("Petrov 1").withLastname("Petrovich 1")
            .withNick("tester.1").withHomephone("11-11-11").withMobilephone("+7(900)111 11 11")
            .withWorkphone("8-800-000-00-00").withFirstmail("tester1@rrr.com").withSecondmail("tester2@gmail.com")
            .withFirdmail("tester@666.ru").withUserhomepage("http://localhost").withPhoto(photo)});
    list.add(new Object[] {new ContactData().withFirstname("Dany").withLastname("Jones")
            .withHomephone("11-11-11").withMobilephone("+7(900)111 11 11")
            .withWorkphone("8-800-000-00-00")});
    list.add(new Object[] {new ContactData().withFirstname("Dany 2").withLastname("Jones 2")
            .withFirstmail("111@1.com").withSecondmail("222@2.com").withFirdmail("333@3.cpom")});
    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact
            .withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("'4").withGroup("[none]");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}
