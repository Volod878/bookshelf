package ru.volod878.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.volod878.bookshelf.dao.AuthorDao;
import ru.volod878.bookshelf.dao.BookDao;
import ru.volod878.bookshelf.model.Author;
import ru.volod878.bookshelf.model.Book;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookshelfController {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    @Autowired
    public BookshelfController(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(@RequestParam(name = "sort_by", defaultValue = "") String sortBy) {
        switch (sortBy) {
            case "id":
                return bookDao.getAll()
                        .stream()
                        .sorted(Comparator.comparing(Book::getId))
                        .collect(Collectors.toList());
            case "name":
                return bookDao.getAll()
                        .stream()
                        .sorted(Comparator.comparing(Book::getName))
                        .collect(Collectors.toList());
            default:
                return bookDao.getAll();
        }
    }

    @GetMapping("/books/filter")
    public List<Book> getAllExistingBooks(@RequestParam(name = "exist") boolean exist) {
        return bookDao.getAll()
                .stream()
                .filter(book -> book.getExist() == exist)
                .collect(Collectors.toList());
    }

    @GetMapping("/author/{id}/books")
    public List<Book> findAllBooksByAuthor(@PathVariable long id) {
        return bookDao.getAllByAuthor(id);
    }

    @PostMapping("/author/{id}/books")
    public Book addNewBook(@PathVariable long id, @RequestBody Book book) {
        book.setAuthor(authorDao.getById(id));
        bookDao.save(book);
        return book;
    }

    @PostMapping("/authors")
    public Author addNewAuthor(@RequestBody Author author) {
        authorDao.save(author);
        return author;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        bookDao.save(book);
        return book;
    }

    @PutMapping("/authors")
    public Author updateAuthor(@RequestBody Author author) {
        authorDao.save(author);
        return author;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable long id) {
        bookDao.deleteById(id);
        return "Book with ID = " + id + " was deleted";
    }
}
