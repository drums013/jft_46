package training.pft.addressbook.tests;

import org.testng.annotations.Test;
import training.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1_edited", "test2_edited", "test3_edited"));
    app.getGroupHelper().submitGroupModification();
  }
}