package training.pft.addressbook.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nick;
  private String homephone;
  private String mobilephone;
  private String workphone;
  private String firstmail;
  private String secondmail;
  private String firdmail;
  private String userhomepage;
  private String group;
  private String allPhones;
  private String firstAddress;
  private String allEmails;
  private File photo;

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNick(String nick) {
    this.nick = nick;
    return this;
  }

  public ContactData withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  public ContactData withMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
    return this;
  }

  public ContactData withWorkphone(String workphone) {
    this.workphone = workphone;
    return this;
  }

  public ContactData withFirstmail(String firstmail) {
    this.firstmail = firstmail;
    return this;
  }

  public ContactData withSecondmail(String secondmail) {
    this.secondmail = secondmail;
    return this;
  }

  public ContactData withFirdmail(String firdmail) {
    this.firdmail = firdmail;
    return this;
  }

  public ContactData withUserhomepage(String userhomepage) {
    this.userhomepage = userhomepage;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withFirstAddress(String firstAddress) {
    this.firstAddress = firstAddress;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public File getPhoto() {
    return photo;
  }

  public int getId() {
    return id;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNick() {
    return nick;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getWorkphone() {
    return workphone;
  }

  public String getFirstmail() {
    return firstmail;
  }

  public String getSecondmail() {
    return secondmail;
  }

  public String getFirdmail() {
    return firdmail;
  }

  public String getUserhomepage() {
    return userhomepage;
  }

  public String getGroup() {
    return group;
  }

  public String getFirstAddress() {
    return firstAddress;
  }

  public String getAllEmails() {
    return allEmails;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

}
