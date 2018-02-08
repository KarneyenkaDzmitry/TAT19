import java.io.UnsupportedEncodingException;

public class Symbols {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String help = "Put a string as the first parameter";
        if (args.length > 0) {
            char[] chars = args[0].toCharArray();
            String src = "Это пример текста";
            byte[] b = src.getBytes("UTF-8");
            String dst = new String(b, "CP866");
            System.out.println(dst);
            byte[] bytes = args[0].getBytes("CP1251");
            String stringCp866 = new String(bytes, "CP866");
            String stringUtf8 = new String(bytes, "UTF-8");
            String stringCp1251 = new String(bytes, "CP1251");
            System.out.println("Compare:");
            System.out.println("Encoding CP1251:" + stringCp1251);
            System.out.println("Encoding CP866 :" + stringCp866);
            System.out.println("Encoding UTF-8 :" + stringUtf8);

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
            System.out.println("Nothing was entered.");
            System.out.println(help);
        }
    }
}
