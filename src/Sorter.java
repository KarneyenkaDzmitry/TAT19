import java.util.*;

public class Sorter {
    public static void main(String[] args) {
        String help = "Put values via space as arguments of the program.";
        if (args.length > 0) {
            Arrays.sort(args);
            System.out.println("These are sort entered values:");
            for (String s : args) {
                System.out.print(s + " ");
            }
            Set<String> set = new HashSet<String>();
            Collections.addAll(set, args);
            List<String> list = new LinkedList<String>(set);
            Collections.sort(list);
            System.out.println("\nThese are unique values:");
            for (String str : list) {
                System.out.print(str + " ");
            }
        } else {
            System.out.println("Nothing was entered.");
            System.out.println(help);
        }
    }
}

