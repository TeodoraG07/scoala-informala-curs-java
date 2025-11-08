package projectlibrarycatalog;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BookManagement myBookManagement = new BookManagement();
        // myBookManagement.listInfo();
        BookManagement myBookManagement1 = new BookManagement();
        myBookManagement1.addBook(new Album("NoWill", 40, "Poor", "Album"));
        // myBookManagement1.listInfo();
        BookManagement myBookManagement2 = new BookManagement();
        myBookManagement2.deleteBook(new Album("NoWill", 40, "Poor", "Album"));
        BookManagement myBookManagement3 = new BookManagement();
        myBookManagement3.addBook(new Novel("Stupid Will", 40, "Drama", "Novel"));
        myBookManagement3.listInfo();
    }
}
