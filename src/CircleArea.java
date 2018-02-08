public class CircleArea {
    public static void main(String[] args) {
        String help = "Put a radius of a circle as the first parameter.\n" +
                "The parameter have to be a positive number.";
        if (args.length > 0) {
            int radius = 0;
            try {
                radius = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Number format is wrong!");
                System.out.println(help);
                System.exit(1);
            }
            if (radius >= 0) {
                double area = Math.PI * Math.pow(radius, 2);
                System.out.println("Area of the circle is: " + area);
            } else {
                System.out.println("Number format is wrong!");
                System.out.println(help);
            }
        } else {
            System.out.println(help);
        }
    }
}
