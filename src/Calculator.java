public class Calculator {

    public static void main(String[] args) {
        String help = new String("Put three parameters as arguments via space:" +
                "\nthe first is a number, the second is mathematical sign (+, -, x, /), " +
                "\nthe third is a number. After that push enter.\nFor example: 3 x 5");
        if ((args.length > 0) && (args.length < 4)) {
            Double a = null;
            Double b = null;
            try {
                a = Double.parseDouble(args[0]);
                b = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Number format is wrong!");
                System.out.println(help);
                System.exit(0);
            }
            switch (args[1]) {
                case "-":
                    System.out.println(a - b);
                    break;
                case "+":
                    System.out.println(a + b);
                    break;
                case "x":
                    System.out.println(a * b);
                    break;
                case "/":
                    if (b != 0) {
                        System.out.println(a / b);
                        break;
                    } else {
                        System.out.println("Can not be divided by zero");
                    }
                default:
                    System.out.println("Wrong operation!");
                    System.out.println(help);
                    break;
            }
        } else {
            System.out.println(help);
        }
    }
}
