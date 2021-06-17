package core.basesyntax;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_ARRAY = 10;
    private K[] keys;
    private V[] value;
    private int currentLength;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH_ARRAY];
        value = (V[]) new Object[MAX_LENGTH_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentLength; i++) {
            if (key != null && key.equals(keys[i]) || keys[i] == key) {
                this.value[i] = value;
                return;
            }
        }
        keys[currentLength] = key;
        this.value[currentLength] = value;
        currentLength++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentLength; i++) {
            if (key != null && key.equals(keys[i]) || keys[i] == key) {
                return value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentLength;
    }
}
