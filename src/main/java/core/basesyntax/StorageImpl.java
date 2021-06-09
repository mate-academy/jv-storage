package core.basesyntax;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_ARRAY = 10;
    private K[] keysWithStorage;
    private V[] valueWithStorage;
    private int lengthStorage = 0;

    public StorageImpl() {
        keysWithStorage = (K[]) new Object[MAX_LENGTH_ARRAY];
        valueWithStorage = (V[]) new Object[MAX_LENGTH_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < lengthStorage; i++) {
            if (key != null && key.equals(keysWithStorage[i]) || keysWithStorage[i] == key) {
                valueWithStorage[i] = value;
                return;
            }
        }
        keysWithStorage[lengthStorage] = key;
        valueWithStorage[lengthStorage] = value;
        lengthStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < lengthStorage; i++) {
            if (key != null && key.equals(keysWithStorage[i]) || keysWithStorage[i] == key) {
                return valueWithStorage[i];
            }
        }
        System.out.println("Sorry, this key absent in Storage list");
        return null;
    }

    @Override
    public int size() {
        return lengthStorage;
    }
}
