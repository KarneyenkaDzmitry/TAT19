public class Rand {
    public static void main(String[] args) {
        String help = "Put amount of digits of random number as the first parameter.\n" +
                "The number have to be positive integer.";
        if (args.length > 0) {
            int amountOfDigits = 0;
            try {
                amountOfDigits = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Number format is wrong!");
                System.out.println(help);
                System.exit(1);
            }
            if (amountOfDigits > 0) {
                long randomNumber = Rand.RandomIntegerNumber(amountOfDigits);
                System.out.println("Random number: " + randomNumber);
            } else {
                System.out.println(help);
            }
        } else {
            System.out.println(help);
        }
    }

    public static long RandomIntegerNumber(int number) {
        long randomNumber = (long) (Math.random() * Math.pow(10, number));
        return randomNumber;
    }
}

