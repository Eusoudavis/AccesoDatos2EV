package Interfaces;

import java.util.List;

public interface Interfaz <T, K>{
    void create(T t);

    T findById(K k);

    List<T> read();

    void delete(T t) throws Exception;
}
