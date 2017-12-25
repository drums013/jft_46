package training.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import training.pft.addressbook.model.ContactData;
import training.pft.addressbook.model.Contacts;
import training.pft.addressbook.model.GroupData;
import training.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("Vasya"), true);
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testAddContactToGroup() {
    Contacts contact = app.db().contacts();
    Groups group = app.db().groups();
    ContactData contactToAddToGroup = contact.iterator().next();
    GroupData groupToAddContact = group.iterator().next();
    Groups beforeAdded = app.db().contactsInGroups();
    app.goTo().homePage();
    app.contact().addToGroup(contactToAddToGroup, groupToAddContact);
    app.goTo().homePage();
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(contact.size()));
    Groups afterAdded = app.db().contactsInGroups();

    assertThat((afterAdded), equalTo(new Groups(beforeAdded.withAdded(groupToAddContact))));
  }
}
