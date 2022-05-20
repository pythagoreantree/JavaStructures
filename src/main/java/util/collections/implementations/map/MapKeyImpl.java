package util.collections.implementations.map;

import util.collections.interfaces.map.MapKey;

public class MapKeyImpl<K> implements MapKey<K> {

    private K k;

    MapKeyImpl(){

    }

    MapKeyImpl(K key){
        k = key;
    }

    public K get() {
        return k;
    }
}
