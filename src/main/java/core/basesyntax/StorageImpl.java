package core.basesyntax;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keyArray = (K[]) new Object[MAX_SIZE];
    private final V[] valueArray = (V[]) new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        boolean alreadyContain = false;
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (key == keyArray[i]) {
                    valueArray[i] = (V) value;
                    alreadyContain = true;
                    break;
                } else {
                    continue;
                }
            } else if (key.equals(keyArray[i])) {
                valueArray[i] = (V) value;
                alreadyContain = true;
            }
        }
        if (!alreadyContain) {
            keyArray[size()] = (K) key;
            valueArray[size()] = (V) value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (key == keyArray[i]) {
                    return (V) valueArray[i];
                } else {
                    continue;
                }
            } else if (key.equals(keyArray[i])) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
