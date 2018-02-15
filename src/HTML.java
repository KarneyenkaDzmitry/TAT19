import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.*;

/*Приложение находит все файлы и директории текущего каталога, и записывает в HTML - файл таблицу со значениями
ИМЯ / ТИП / ДАТА СОЗДАНИЯ / РАЗМЕР (в KB)
Алгоритм: Проход по всему дереву файлов и каталогов и запись всех данных в List или Map. Затем создать файл и
 * Записать эти данные в виде HTML документа в таблицу. */
public class HTML {

    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<String>();
        Path path = Paths.get(System.getProperty("user.dir"));//System.out.println("Текущий каталог: " + path);
        File[] files = new File(path.toString()).listFiles();
        for (File file : files) {
            Path path1 = file.toPath();
            if (Files.isDirectory(path1)) {
                BasicFileAttributes attrs = Files.readAttributes(path1, BasicFileAttributes.class);
                Date date = new Date(attrs.creationTime().toMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
                long size = HTML.getDirSize(path1.toString());
                String sizeKB = String.format("%.2f", (size * 1.0) / 1024);
                list.add("<tr><td>" + path1.getFileName() + "</td>\n" +
                        "<td>DIR</td>\n" +
                        "<td>" + sdf.format(date)+ "</td>\n" +
                        "<td>" + sizeKB + "</td>\n" +
                        "</tr>");
            } else {
                BasicFileAttributes attrs = Files.readAttributes(path1, BasicFileAttributes.class);
                Date date = new Date(attrs.creationTime().toMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
                byte[] bytes = Files.readAllBytes(path1);
                long size =  bytes.length;
                String sizeKB = String.format("%.2f", (size * 1.0) / 1024);
                list.add("<tr><td>" + path1.getFileName() + "</td>\n" +
                        "<td>FILE</td>\n" +
                        "<td>" + sdf.format(date)+ "</td>\n" +
                        "<td>" + sizeKB + "</td>\n" +
                        "</tr>");
            }
        }
        /*C этого места начинается запись в строк в файл.*/
        Path pathHTML = Paths.get(path.toString()+"//HTMLTable.html");
        File fileHTML = new File(pathHTML.toString());
        BufferedWriter bfw = new BufferedWriter(new FileWriter(fileHTML));
        bfw.write("<html>\n" +
                "<head>List of directories and files.\n" +
                "</head>\n" +
                "<body>\n" +
                "<title>List of directories and files.\n" +
                "</title>\n" +
                "<table  cellspacing=25, border=1,  cellpadding=0.5>\n" +
                "<tr>\n" +
                "<td>File Name</td>\n" +
                "<td>Type of File</td>\n" +
                "<td>Created Date</td>\n" +
                "<td>Size of File (KB)</td>\n" +
                "</tr>");
        for (String line:list) {
            bfw.write(line);
        }
        bfw.write("</table>\n" +
                "  </body>\n" +
                "</html>");
        bfw.close();
    }
    /*Данный метод проходит по дереву и находит все файлы во входной директории.
    * Возвращает размер директории в байтах.*/
    public static long getDirSize(String root) throws IOException {
        List<String> listResults = new ArrayList<String>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(root);
        while (true) {
            try {
                String nameFile = queue.poll();
                if (nameFile != null) {
                    File files = new File(nameFile);
                    for (File name : files.listFiles()) {
                        if (name.isDirectory()) {
                            queue.add(name.getAbsolutePath());
                        } else {
                            listResults.add(name.getPath());
                        }
                    }
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        long size = 0;
        for (String str : listResults) {
            Path path = Paths.get(str);
            byte[] bytes = Files.readAllBytes(path);
            size = size + bytes.length;
        }
        return size;
    }
}
