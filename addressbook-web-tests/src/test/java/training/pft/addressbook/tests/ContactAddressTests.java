package training.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import training.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstAddress("  \n    ul. Lunacharskogo, 186-190\n" +
              "Ekaterinburg\n" +
              "Sverdlovskaya obl.").withGroup("[none]"), true);
    }
  }

  @Test
  public void testContactAddresses() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getFirstAddress(), equalTo(cleaned(contactInfoFromEditForm.getFirstAddress())));
  }

  public static String cleaned(String address) {
    return address.replaceAll("^(\\s+|\\n+)|(\\s+|\\n+)$", "")
            .replaceAll(" +", " ").replaceAll("\\n ", "\n")
            .replaceAll(" \\n", "\n");
  }
}



