package util.collections.implementations.map;

import util.collections.interfaces.map.MapKey;
import util.collections.interfaces.map.MapPair;
import util.collections.interfaces.map.MapValue;

public class MapPairImpl<K, V> implements MapPair<K, V> {

    private MapKeyImpl<K> key;
    private MapValueImpl<V> value;

    public MapPairImpl(K key, V value) {
        this.key = new MapKeyImpl<K>(key);
        this.value = new MapValueImpl<V>(value);
    }

    public MapKey getKey() {
        return key;
    }

    public MapValue getValue() {
        return value;
    }
}
