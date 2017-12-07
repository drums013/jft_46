package training.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")

public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "middlename")
  private String middlename;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "nickname")
  private String nick;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homephone;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilephone;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String workphone;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String firstmail;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String secondmail;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String firdmail;

  @Expose
  @Column(name = "homepage")
  @Type(type = "text")
  private String userhomepage;

  @Expose
  @Transient
  private String group;

  @Transient
  private String allPhones;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String firstAddress;

  @Transient
  private String allEmails;

  @Expose
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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
    if (photo == null) {
      return null;
    } else {
      return new File(photo);
    }
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
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", homephone='" + homephone + '\'' +
            ", mobilephone='" + mobilephone + '\'' +
            ", workphone='" + workphone + '\'' +
            ", firstmail='" + firstmail + '\'' +
            ", secondmail='" + secondmail + '\'' +
            ", firdmail='" + firdmail + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (homephone != null ? !homephone.equals(that.homephone) : that.homephone != null) return false;
    if (mobilephone != null ? !mobilephone.equals(that.mobilephone) : that.mobilephone != null) return false;
    if (workphone != null ? !workphone.equals(that.workphone) : that.workphone != null) return false;
    if (firstmail != null ? !firstmail.equals(that.firstmail) : that.firstmail != null) return false;
    if (secondmail != null ? !secondmail.equals(that.secondmail) : that.secondmail != null) return false;
    return firdmail != null ? firdmail.equals(that.firdmail) : that.firdmail == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
    result = 31 * result + (mobilephone != null ? mobilephone.hashCode() : 0);
    result = 31 * result + (workphone != null ? workphone.hashCode() : 0);
    result = 31 * result + (firstmail != null ? firstmail.hashCode() : 0);
    result = 31 * result + (secondmail != null ? secondmail.hashCode() : 0);
    result = 31 * result + (firdmail != null ? firdmail.hashCode() : 0);
    return result;
  }
}
