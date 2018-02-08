public class Sequence {
    public static void main(String[] args) {
        String help = "Put a number as the first parameter.\n" +
                "The parameter have to be integer.";
        if (args.length > 0) {
            int number = 0;
            try {
                number = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Number format is wrong!");
                System.out.println(help);
                System.exit(1);
            }
            if (number != 0) {
                //int digits = (int) Math.log10(Math.abs(number)) + 1;
                boolean ind = true;
                char[] count = args[0].toCharArray();
                for (int i = 0; i < count.length - 1; i++) {
                    if (count[i] > count[i + 1]) {
                        ind = false;
                        break;
                    }
                }
                if (ind == true) System.out.println("The sequence is good.");
                else System.out.println("The sequence is bad.");
            } else {
                System.out.println("It is a zero!");
                System.out.println(help);
            }
        } else {
            System.out.println(help);
        }
    }
}
