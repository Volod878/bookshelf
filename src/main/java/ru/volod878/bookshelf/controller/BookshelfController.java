package ru.volod878.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.volod878.bookshelf.dao.AuthorDao;
import ru.volod878.bookshelf.dao.BookDao;
import ru.volod878.bookshelf.model.Author;
import ru.volod878.bookshelf.model.Book;

import java.util.List;

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
    public List<Book> getAllBooks() {
        return bookDao.getAll();
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
