package pkg;

import java.io.IOException;

public class JsoupRSS {
    public static void main(String[] args) throws IOException {
        RSSReader rss = new RSSReader();
        Article[] articles = rss.getItem("https://udn.com/rssfeed/news/2/7225?ch=news");
        for (Article d : articles) {
            System.out.println(d);
        }
        
    }
}
