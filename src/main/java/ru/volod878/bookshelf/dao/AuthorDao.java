package ru.volod878.bookshelf.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.volod878.bookshelf.model.Author;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AuthorDao implements Dao<Author> {

    private final EntityManager entityManager;

    @Autowired
    public AuthorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Author> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Author", Author.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Author author) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(author);
    }

    @Override
    @Transactional
    public Author getById(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Author.class, id);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Author author = session.get(Author.class, id);
        session.delete(author);
    }
}
