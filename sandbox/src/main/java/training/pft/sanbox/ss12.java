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

    double l = 5;
    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

    double a = 4;
    double b = 6;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
 }

 public static void hello(String somebody) {
   System.out.println("Hello, " + somebody + "!");
 }

 public static double area(double len) {
   return  len * len;
 }

 public static double area(double a, double b) {
   return a * b;
 }

}