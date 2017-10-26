package training.pft.sandbox;

//Задание 2

public class DistanceBetweenPoints {

  public static void main(String[] args) {

    Point p1 = new Point(5, 7);
    Point p2 = new Point(66, 56);
    System.out.println("Расстояние между точками P1 (x1: " + p1.x + ", y1: " + p1.y + ") " +
            "и P2 (x2: " + p2.x + ", y2: " + p2.y + ") = " + p1.distance(p2));

  }



  //Функция из пунтка 3:
  public static double distance(Point p1, Point p2) {
    return Math.sqrt(((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y)));
  }
}
