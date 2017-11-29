package training.pft.addressbook.generators;

import training.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void  main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts  = generateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname()
              , contact.getHomephone(), contact.getMobilephone(), contact.getWorkphone()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstname(String.format("Vasya %s", i))
              .withLastname(String.format("Petrovich %s", i)).withHomephone(String.format("00-00-00 %s", i))
      .withMobilephone(String.format("Petrovich %s", i)).withMobilephone(String.format("+7(000)00-00-00 %s", i))
      .withWorkphone(String.format("+8 800 00 00 00 %s", i)));
    }
    return contacts;
  }
}
