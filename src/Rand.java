public class Rand {
    public static void main(String[] args) {
        String help = "Put amount of digits of random number as the first parameter.\n" +
                "The number have to be positive Long.";
        if (args.length > 0) {
            long amountOfDigits = 0;
            try {
                amountOfDigits = Long.parseLong(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Number format is wrong!");
                System.out.println(help);
                System.exit(1);
            }
            if (amountOfDigits > 0) {
                String randomNumber = Rand.RandomStringNumber(amountOfDigits);
                System.out.println("Random number: " + randomNumber);
            } else {
                System.out.println(help);
            }
        } else {
            System.out.println(help);
        }
    }

    private static String RandomStringNumber(long number) {
        StringBuilder builder = new StringBuilder();
        for (long i = number / 9; i > 0; i--) {
            builder.append((long) (Math.random() * (Math.pow(10, 9) + 1)));
        }
        builder.append((long) (Math.random() * Math.pow(10, number % 9)));
        return builder.toString();
    }
}

