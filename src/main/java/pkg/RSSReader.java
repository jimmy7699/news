package pkg;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class RSSReader {
    public RSSReader(){
    }
    public Article[] getItem (String url)  throws IOException{
        Document doc = Jsoup.connect(url).get();
        Elements items = doc.select("item");
        Article[] articles = new Article[items.size()];
        for(int i=0;i<items.size();i++){
            articles[i] = new Article();
            Element el = items.get(i);
            articles[i].setTitles(el.select("title").text()+"\n");
            articles[i].setLinks(el.select("link").text()+"\n");
            articles[i].setPubDates(el.select("pubDate").text()+"\n");
            articles[i].setDescriptions(el.select("description").text()+"\n");
        }
        return articles;
    }
}