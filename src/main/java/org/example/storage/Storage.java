package org.example.storage;

public interface Storage<T, ID> {

    T save(T entity);
}
