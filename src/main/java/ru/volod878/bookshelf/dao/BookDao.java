package ru.volod878.bookshelf.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.volod878.bookshelf.model.Book;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookDao implements Dao<Book> {

    private final EntityManager entityManager;

    @Autowired
    public BookDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Book> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Book", Book.class).getResultList();
    }

    @Transactional
    public List<Book> getAllByAuthor(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Book> query = session.createQuery("from Book where author_id=:authorId", Book.class);
        query.setParameter("authorId", id);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Book book) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(book);
    }

    @Override
    @Transactional
    public Book getById(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Book.class, id);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Book book = session.get(Book.class, id);
        session.delete(book);
    }
}
