public class HelloName {

    public static void main(String[] args) {
        while (true) {
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("exit")) break;
                System.out.println("Hello, " + args[0]);
                break;
            } else {
                System.out.println("Put your name as the first parameter to see \"Hello, YOUR NAME.\"");
                System.out.println("Enter \"exit\" to exit.");
            }
        }
    }
}
