package training.pft.sanbox;

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
 }

 public static void hello(String somebody) {
   System.out.println("Hello, " + somebody + "!");
 }

}