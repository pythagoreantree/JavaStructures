package util.collections.interfaces.map;

import util.collections.Container;
import util.collections.interfaces.collection.set.Set;
import util.collections.interfaces.collection.Collection;

public interface Map<K, V> extends Container {

    V get(K key);

    V put(K key, V value);

    boolean containsKey(K key);

    boolean containsValue(V value);

    void putAll(Map<? extends K, ? extends V> m);

    boolean remove(Object key);

    Set<K> keySet();

    Collection<V> values();

    Set<MapPair<K,V>> entrySet();

}
