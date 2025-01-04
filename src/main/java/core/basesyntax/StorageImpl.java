package core.basesyntax;

public class StorageImpl<K, V> implements Storage<K, V> {
private static final int MAX_CAPACITY = 10;
private K[] keys;
private V[] values;
private int size;

public StorageImpl() {
    keys = (K[]) new Object[MAX_CAPACITY];
    values = (V[]) new Object[MAX_CAPACITY];
    size = 0;
}


@Override
    public void put(Object key, Object value) {
    for (int i = 0; i < size; i++) {
        if (keys[i].equals(key)) {
            values[i] = (V) value;
            return;
        }
    }
    if (size >= MAX_CAPACITY) {
        throw new IllegalStateException("Storage is full");
    }
    keys[size] = (K) key;
    values[size] = (V) value;
    size++;
}
    @Override
    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) { // Якщо ключ знайдено
                return values[i];      // Повернути відповідне значення
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
