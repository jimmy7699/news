package pkg;

public class Article {

    private String Titles;
    private String Links;
    private String PubDates;
    private String Descriptions;

    public String getTitles() {
        return Titles;
    }

    public void setTitles(String Titles) {
        this.Titles = Titles;
    }

    public String getLinks() {
        return Links;
    }

    public void setLinks(String Links) {
        this.Links = Links;
    }

    public String getPubDates() {
        return PubDates;
    }

    public void setPubDates(String PubDates) {
        this.PubDates = PubDates;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String Descriptions) {
        this.Descriptions = Descriptions;
    }
    @Override
    public String toString() {
        return "Title:" + getTitles() + "Link:" + getLinks() + "PubDate:" + getPubDates() + "Description:" + getDescriptions();
    }
}
