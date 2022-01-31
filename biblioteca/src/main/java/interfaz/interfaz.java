package interfaz;

import java.util.List;

public interface interfaz<T, K> {

	void create(T t);

	T findById(K k);

	List<T> read();

	void update(T t);

	void delete(T t);

}
