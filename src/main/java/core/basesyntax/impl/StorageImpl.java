
public class StorageImpl<K, V> implements Storage<K, V> {


    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
        size = 0;
    }


    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (size < 10) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("State is full");

        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;

    }

    @Override
    public int size() {
        return size;
    }
}
