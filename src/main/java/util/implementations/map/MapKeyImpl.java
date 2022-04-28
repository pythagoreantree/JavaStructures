package util.implementations.map;

import util.interfaces.map.MapKey;

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
