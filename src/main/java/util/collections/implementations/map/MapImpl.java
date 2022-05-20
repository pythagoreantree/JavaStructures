package util.collections.implementations.map;

import util.collections.interfaces.collection.Collection;
import util.collections.interfaces.collection.set.Set;
import util.collections.interfaces.map.Map;
import util.collections.interfaces.map.MapKey;
import util.collections.interfaces.map.MapPair;

public class MapImpl<K, V> implements Map<K, V> {

    private int size;

    public MapPair<K,V>[] pairs = new MapPair[1000];


    public V get(K key) {

        MapKey k = new MapKeyImpl(key);
        for (int i=0; i<1; i++){
            if (pairs[i].getKey().get().equals(k.get())){
                return pairs[i].getValue().get();
            }
        }
        return null;
    }

    public V put(K key, V value) {
        return null;
    }

    public boolean containsKey(K key) {
        return false;
    }

    public boolean containsValue(V value) {
        return false;
    }

    public void putAll(Map<? extends K, ? extends V> m) {

    }

    public boolean remove(Object key) {
        return false;
    }

    public Set<K> keySet() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }

    public Set<MapPair<K, V>> entrySet() {
        return null;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear() {

    }
}
