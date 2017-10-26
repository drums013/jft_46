package training.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


  @Test
  public void testDistance1() {
    Point p1 = new Point(5,7);
    Point p2 = new Point(66, 56);
    Assert.assertEquals(p1.distance(p2), 78.24321056807422);

  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(2,0);
    Point p2 = new Point(2,0);
    Assert.assertNotNull(p1.distance(p2));

  }

  @Test
  public void testDistance3() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(-666, -7.5);
    Point p3 = new Point(1, 1);
    Point p4 = new Point(-666, -7.5);
    Assert.assertEquals(p1.distance(p3), p2.distance(p4));

  }

  @Test
  public void testDistance4() {
    Point p1 = new Point(-64, -7.5);
    Point p2 = new Point(-65, -7.5);
    Point p3 = new Point(-65, -7.5);
    Assert.assertNotEquals(p1.distance(p2), p2.distance(p3));

  }

}
