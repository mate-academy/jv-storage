package core.basesyntax;

public interface Storage<K, V> {
    Object[] getKeyObjects();

    Object[] getStorageObjects();

    void put(K key, V value);

    V get(K key);

    int size();
}
