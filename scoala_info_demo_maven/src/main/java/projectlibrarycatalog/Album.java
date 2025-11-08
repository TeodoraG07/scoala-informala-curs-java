package projectlibrarycatalog;

import java.util.List;

public class Album extends Book {
    private String paperQuality;

    public Album(String title, int pageNumbers, String paperQuality, String category) {
        super(title, pageNumbers, category);
        this.paperQuality = paperQuality;
    }

    public void listInfo() {
        System.out.println("Title:" + " " + title + "," + "category:" + category + "page numbers:" + " " + pageNumbers + " " + "Paper Quality:" + " " + paperQuality);
    }
}

