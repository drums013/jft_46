package training.pft.sandbox;

public class Ss12 {

  public static void main(String[] args) {

    System.out.println("       #####################         ");
    System.out.println("     ######             ######       ");
    System.out.println("    #####                 ######     ");
    System.out.println("   ####                     #####    ");
    System.out.println("  ####                        #####  ");
    System.out.println(" ####     ####        ####      ###  ");
    System.out.println(" ###     ######      ######     #### ");
    System.out.println("####     ######      ######      ####");
    System.out.println("###       ####        ####       ####");
    System.out.println("###                              ####");
    System.out.println("###                              ####");
    System.out.println("###                              ####");
    System.out.println("###     ###              ###     ####");
    System.out.println("####     ##################      ####");
    System.out.println(" ###                             ####");
    System.out.println(" ####                            ### ");
    System.out.println("  ####                         ##### ");
    System.out.println("   ####                      #####   ");
    System.out.println("    #####                 ######     ");
    System.out.println("     #########################       ");
    System.out.println("      #####################          ");

    hello("world");
    hello("user");
    hello("Ilya");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p1 = new Point(0, 7);
    p1.x = 5;
    p1.y = 7;

    Point p2 = new Point(66, 56);
    p2.x = 66;
    p2.y = 56;

    System.out.println("Расстояние между точками P1 (x1: " + p1.x + ", y1: " + p1.y + ") и P2 (x2: " + p2.x + ", y2: " + p2.y + ") = " + p1.distance(p2));

 }

 public static void hello(String somebody) {
   System.out.println("Hello, " + somebody + "!");
 }


}