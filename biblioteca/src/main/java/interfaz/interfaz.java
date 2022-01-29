package interfaz;

import java.util.List;

public interface interfaz<T, K> {

	void create(T t);

	T findById(K k);

	List<T> read();

	T update(K k);

	void delete(T t);

}
