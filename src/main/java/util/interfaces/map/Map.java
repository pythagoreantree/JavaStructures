package util.interfaces.map;

import util.interfaces.Container;
import util.interfaces.collection.set.Set;
import util.interfaces.collection.Collection;

public interface Map<K, V> extends Container {

    V get(K key);

    V put(K key, V value);

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    void putAll(Map<? extends K, ? extends V> m);

    boolean remove(Object key);

    Set<K> keySet();

    Collection<V> values();

    Set<MapEntry<K, V>> entrySet();

}
