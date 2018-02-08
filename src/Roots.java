import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Roots {

    public static void main(String[] args) {

        String help = new String("Put three parameters as arguments via space." +
                " the parameters have to be numbers" +
                ". After that push enter.");
        if ((args.length > 0) && (args.length < 4)) {
            Double x1, x2;
            Double a = null;
            Double b = null;
            Double c = null;
            try {
                a = Double.parseDouble(args[0]);
                b = Double.parseDouble(args[1]);
                c = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Wrong entering data.");
                System.out.println(help);
            }
            if (a != 0) {
                Double d = pow(b, 2) - 4 * a * c;
                if (d < 0) System.out.println("The equation doesn't have any roots.");
                if (d > 0) {
                    x1 = (-b + sqrt(d)) / (2 * a);
                    x2 = (-b - sqrt(d)) / (2 * a);
                    System.out.println("The equation has two roots: X1 = " + x1 + "; X2 = " + x2 + ".");
                }
                if (d == 0) {
                    x1 = (-b) / (2 * a);
                    System.out.println("The equation has one root: X = " + x1 + ".");
                }
            } else {
                if (b != 0) {
                    x1 = (-c) / (b);
                    System.out.println("The equation has one root: X = " + x1 + ".");
                } else {
                    System.out.println("The equation is wrong.");
                    System.out.println(help);
                }
            }
        }
    }
}
