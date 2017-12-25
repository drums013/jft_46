package training.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import training.pft.addressbook.model.ContactData;
import training.pft.addressbook.model.Contacts;
import training.pft.addressbook.model.GroupData;
import training.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData(), true);
    }
    if (app.contact().count() == 0){
      Groups groups = app.db().groups();
      if (groups.size() > 0) {
        app.contact().create(new ContactData().inGroup(groups.iterator().next()), true);
      }
    } else {
      Contacts contacts = app.db().contacts();
      if (contacts.iterator().next().getGroups().count() == 0){
        app.contact().addToGroup(contacts.iterator().next(), app.db().groups().iterator().next());
      }
    }
  }

  @Test
  public void testDeleteContactFromGroup() {
    app.goTo().homePage();
    Groups before = app.db().contacts().iterator().next().getGroups();
    Contacts contacts = app.db().contacts();
    app.contact().removeFromGroup(contacts.iterator().next(),
            contacts.iterator().next().getGroups().iterator().next());
    app.goTo().homePage();
    app.contact().selectAll();
    assertThat(app.db().contacts().iterator().next().getGroups().count(),
            equalTo(before.count() - 1));
    assertThat(app.db().contacts().iterator().next().getGroups(),
            equalTo(before.without(contacts.iterator().next().getGroups().iterator().next())));
  }
}
