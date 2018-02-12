import java.io.UnsupportedEncodingException;

public class Symbols {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String help = "Put a string as the first parameter. Use \"_\"  between words or put the sentence in \"\".";
        if (args.length > 0) {
            byte[] bytes = args[0].getBytes("CP1251");
            StringBuilder strBuild = new StringBuilder();
            for (int j = 0; j < bytes.length; j++) {
                for (int i = 0; i < 128; i++) {
                    if (i == bytes[j]) {
                        strBuild.append(args[0].charAt(j));
                    }
                }
            }
            if (strBuild.length()>0){
                System.out.println("True. There is a coincidence: ");
                System.out.println(strBuild);
            }
        } else {
            System.out.println("Nothing was entered.");
            System.out.println(help);
        }
    }
}
//            String stringCp866 = new String(bytes, "CP866");
//            String stringUtf8 = new String(bytes, "UTF-8");
//            String stringCp1251 = new String(bytes, "CP1251");
//            System.out.println("Integer " + Integer.toHexString(bytes[0]));
//            System.out.println("Compare:");
//            System.out.println("Encoding CP1251:" + stringCp1251 + " lENGTH: " + stringCp1251.length());
//            System.out.println("Encoding CP866 :" + stringCp866 + " lENGTH: " + stringCp866.length());
//            System.out.println("Encoding UTF-8 :" + stringUtf8 + " lENGTH: " + stringUtf8.length());