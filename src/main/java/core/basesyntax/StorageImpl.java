package core.basesyntax;

import static java.lang.StringUTF16.indexOf;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final static int MAX_SIZE = 10;

    private K[] keys;
    private V[] values;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StorageImpl(K key, V value) {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public void put(K key, V value) {
        if (MAX_SIZE == size) {
            return;
        }
        if (indexOf(key) != -1) {

        }
        keys[size++] = key;
        values[size++] = value;
    }

    private int indexOf(K key) {
        
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
