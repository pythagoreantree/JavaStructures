package util.collections.implementations.map;

import util.collections.interfaces.map.MapValue;

public class MapValueImpl<V> implements MapValue<V> {

    private V v;

    public MapValueImpl() {

    }

    public MapValueImpl(V v) {
        this.v = v;
    }

    public V get() {
        return v;
    }

    public V set(V value) {
        v = value;
        return v;
    }
}
