import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Document document;
        try {
            document = Jsoup.connect("https://www.euro.com.pl/zabawki-zdalnie-sterowane.bhtml").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements content = document.getElementsByClass("price-normal");
        for (Element e :
                content) {
            if(e.parents().hasClass("product-row"))
                System.out.println(e.text());
        }
    }
}
