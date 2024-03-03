package library.controller;

import library.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import library.*;

import java.util.Optional;

@RestController
public class LibraryController {

    @PostMapping("/book")
    public BookIdResponse createBook(@RequestBody BookCreateOrUpdateRequest request) {
        Book book = new Book(request.getName(), request.getYear());
        int id = BookStorage.addBook(book);
        return new BookIdResponse(id);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        Optional<Book> book = BookStorage.getBook(id);
        return book.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(book.get(), HttpStatus.OK);
    }

    @GetMapping("/book")
    public BookListResponse getBookList() {
        return new BookListResponse(BookStorage.getBookList());
    }

    @PutMapping("/book/{id}")
    public void updateBook(@PathVariable Integer id, @RequestBody BookCreateOrUpdateRequest request) {
        Book book = new Book(request.getName(), request.getYear());
        BookStorage.updateBook(id, book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Integer id) {
        BookStorage.deleteBook(id);
    }
}
