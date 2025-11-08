package projectlibrarycatalog;

import java.util.ArrayList;

public class BookManagement {
    private ArrayList<Book> books;

    public BookManagement() {
        books = new ArrayList<>();
        books.add(new Novel("Badwill", 40, "Fantasy", "Novel"));
        books.add(new Album("Goodwill", 67, "Good", "Album"));
        books.add(new Novel("Crazy will", 567, "Thriller", "Novel"));
    }

    public void listInfo() {
        for (Book book : books) {
            book.listInfo();

        }
    }

    public void addBook(Book book) {
        books.add(book);

    }

    public void deleteBook(Book book) {
        books.remove(book);
    }
}
