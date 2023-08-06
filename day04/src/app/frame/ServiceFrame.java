package app.frame;

import java.util.List;

public interface ServiceFrame<K, V> {
	
	public boolean register(V v) throws Exception;

	public boolean modify(V v) throws Exception;

	public boolean remove(K k) throws Exception;
	
	public boolean removeAll() throws Exception;

	public V get(K k) throws Exception;

	public List<V> get() throws Exception;
}
