package ru.volod878.bookshelf.dao;

import java.util.List;

public interface Dao<Entity> {
    List<Entity> getAll();

    void save(Entity entity);

    Entity getById(long id);

    void deleteById(long id);
}
