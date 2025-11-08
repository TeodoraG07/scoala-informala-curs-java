package projectlibrarycatalog;

import java.util.ArrayList;
import java.util.List;

public class Novel extends Book {
    private String type;

    public Novel(String title, int pageNumbers, String type, String category) {
        super(title, pageNumbers, category);
        this.type = type;
    }

    public void listInfo() {
        System.out.println("Title:" + " " + title + "," + "category:" + category + "page numbers:" + " " + pageNumbers + " " + "type:" + type);
    }
}
