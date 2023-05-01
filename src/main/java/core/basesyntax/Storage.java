package core.basesyntax;

public interface Storage<K, V> {
    void put(K key, V value);

    V get(K key);

    int size();

    int getIndex(K key);

    int getIndexNull(K key);
}
