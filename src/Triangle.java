import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
    public static void main(String[] args) throws IOException {
        double a = 0;
        double b = 0;
        double c = 0;
        String[] lines = new String[3];
        String help = "Enter three values of sides of triangle, please.";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(help);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the " + i + " positive number \"a\": ");
            lines[i] = reader.readLine();
        }
        try {
            a = Double.parseDouble(lines[0]);
            b = Double.parseDouble(lines[1]);
            c = Double.parseDouble(lines[2]);
        } catch (NumberFormatException e) {
            System.out.println("Something wrong with numbers.");
            System.out.println("Recall the program. " + help);
            System.exit(1);
        }
        if (Triangle.TriagleExists(a, b, c)) {
            if ((a == b) && (b == c)) {
                System.out.println("Triangle is equilateral.");
            } else {
                if ((a == b) || (b == c) || (c == a)) {
                    System.out.println("Triangle is isosceles.");
                } else {
                    System.out.println("Triangle is versatile.");
                }
            }
        } else {
            System.out.println("Triangle doesn't exist.");
        }
    }
    /* Проверка на существование треугольника :
     *сумма двух сторон должна быть строго больше третьей стороны.*/
    static boolean TriagleExists(double a, double b, double c) {
        if ((a <= 0) || (a >= (b + c))) return false;
        if ((b <= 0) || (b >= (a + c))) return false;
        if ((c <= 0) || (c >= (b + a))) return false;
        return true;
    }
}
