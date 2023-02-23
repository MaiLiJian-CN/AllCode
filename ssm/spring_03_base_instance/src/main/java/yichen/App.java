package yichen;


import yichen.service.BookService;
import yichen.service.Impl.BookServiceImpl;

public class App {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        bookService.save();
    }
}
