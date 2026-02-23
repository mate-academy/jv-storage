package core.basesyntax;

public interface Storage<K, V> {
    void put(K key, V value);

    V get(K key);

    int size();
}


