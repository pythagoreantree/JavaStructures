package util.interfaces.map;

public interface MapEntry<K,V> {

    K getKey();

    V getValue();

    V setValue(V value);

    boolean equals(Object o);

    int hashCode();
}
