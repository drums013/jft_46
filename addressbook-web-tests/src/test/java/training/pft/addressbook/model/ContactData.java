package training.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nick;
  private final String homephone;
  private final String mobilephone;

  private final String workphone;
  private final String firstmail;
  private final String secondmail;
  private final String firdmail;
  private final String userhomepage;
  private String group;

  public ContactData(String firstname, String middlename, String lastname, String nick, String homephone, String mobilephone, String workphone, String firstmail, String secondmail, String firdmail, String userhomepage, String group) {
    this.id = 0;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = nick;
    this.homephone = homephone;
    this.mobilephone = mobilephone;
    this.workphone = workphone;
    this.firstmail = firstmail;
    this.secondmail = secondmail;

    this.firdmail = firdmail;
    this.userhomepage = userhomepage;
    this.group = group;
  }

  public ContactData(int id, String firstname, String middlename, String lastname, String nick, String homephone, String mobilephone, String workphone, String firstmail, String secondmail, String firdmail, String userhomepage, String group) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = nick;
    this.homephone = homephone;
    this.mobilephone = mobilephone;
    this.workphone = workphone;
    this.firstmail = firstmail;
    this.secondmail = secondmail;
    this.firdmail = firdmail;
    this.userhomepage = userhomepage;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
