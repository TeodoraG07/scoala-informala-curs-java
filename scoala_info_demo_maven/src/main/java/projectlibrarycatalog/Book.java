package projectlibrarycatalog;

public class Book {
    protected String title;
    protected int pageNumbers;
    protected String category;

    public Book(String title, int pageNumbers, String category) {
        this.title = title;
        this.pageNumbers = pageNumbers;
        this.category = category;
    }

    public void listInfo() {
        System.out.println("Title:" + " " + title + "," + "category:" + category + "page numbers:" + " " + pageNumbers);

    }
}
