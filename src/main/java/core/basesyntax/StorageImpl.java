package core.basesyntax;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null || (key != null && key.equals(keys[i]))) {
                values[i] = value; // Заміна значення
                return;
            }
        }

        if (size < MAX_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null; // Якщо ключ не знайдено
    }

    @Override
    public int size() {
        return size;
    }
}

