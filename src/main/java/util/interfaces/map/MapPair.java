package util.interfaces.map;

public interface MapPair<K, V> {

    MapKey<K> getKey();

    MapValue<V> getValue();
}
