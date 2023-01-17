package core.basesyntax;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keyArray;
    private final V[] valueArray;
    
    private int size = 0;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_SIZE];
        valueArray = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        boolean alreadyContain = false;
        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                valueArray[i] = value;
                alreadyContain = true;
                break;
            }
        }
        if (!alreadyContain) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
