package library;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

public class BookStorage {
    private static int id = 0;
    private static HashMap<Integer, Book> bookList = new HashMap<>();

    public static int addBook(Book book) {
        int newId = ++id;
        book.setId(newId);
        bookList.put(newId, book);
        return newId;
    }

    public static Optional<Book> getBook(int id) {
        return bookList.containsKey(id) ?
                Optional.of(bookList.get(id)) :
                Optional.empty();
    }

    public static void updateBook(int id, Book book) {
        book.setId(id);
        bookList.put(id, book);
    }

    public static void deleteBook(int id) {
        bookList.remove(id);
    }

    public static Collection<Book> getBookList() {
        return bookList.values();
    }
}
