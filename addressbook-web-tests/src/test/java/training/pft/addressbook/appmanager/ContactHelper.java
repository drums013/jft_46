package training.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import training.pft.addressbook.model.ContactData;
import training.pft.addressbook.model.Contacts;
import training.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactDetails() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillOutContactDetails(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNick());
    type(By.name("home"), contactData.getHomephone());
    type(By.name("mobile"), contactData.getMobilephone());
    type(By.name("work"), contactData.getWorkphone());
    type(By.name("email"), contactData.getFirstmail());
    type(By.name("email2"), contactData.getSecondmail());
    type(By.name("email3"), contactData.getFirdmail());
    type(By.name("homepage"), contactData.getUserhomepage());
    type(By.name("address"), contactData.getFirstAddress());
    attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
     if (contactData.getGroups().size() > 0) {
       Assert.assertTrue(contactData.getGroups().size() == 1);
       new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next()
               .getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void gotoAddContactPage() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    acceptAlert();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }


  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean bool) {
    gotoAddContactPage();
    fillOutContactDetails(contact, bool);
    submitContactDetails();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillOutContactDetails((contact), false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    contactCache = null;
  }


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstname)
              .withLastname(lastname).withAllPhones(allPhones).withAllEmails(allEmails).withFirstAddress(address));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomephone(home).withMobilephone(mobile).withWorkphone(work).withFirstAddress(address)
            .withFirstmail(email).withSecondmail(email2).withFirdmail(email3);
  }

  public void addToGroup(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(group.getName());
    wd.findElement(By.cssSelector("input[value='Add to']")).click();
  }

  public void removeFromGroup(ContactData contact, GroupData group) {
    initRemoveFromGroup(group);
    selectContactById(contact.getId());
    new Select(wd.findElement(By.cssSelector("select[name='to_group']"))).selectByVisibleText(group.getName());
    wd.findElement(By.cssSelector("input[name='remove']")).click();
  }

  private void initRemoveFromGroup(GroupData group) {
    new Select(wd.findElement(By.cssSelector("select[name='group']"))).selectByVisibleText(group.getName());
  }

  public void selectAll() {
    new Select(wd.findElement(By.cssSelector("select[name=\"group\"]"))).selectByVisibleText("[all]");
  }
}
