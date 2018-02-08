
public class News {
    public static void main(String[] args) {
        String help = "Put amount of news as the first parameter.\n" +
                "The number have to be integer. ";
        if (args.length > 0) {
            int amountOfNews = 0;
            try {
                amountOfNews = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Number format is wrong!");
                System.out.println(help);
                System.exit(1);
            }
            int amountOfLists = News.CountListsOfTenNews(amountOfNews);
            System.out.println("Need " + amountOfLists + " pages to show " + amountOfNews + " news.");
        } else {
            System.out.println(help);
        }
    }

    public static int CountListsOfTenNews(int number) {
        int lists = number / 10;
        lists += number % 10 > 0 ? 1 : 0;
        return lists;
    }
}
