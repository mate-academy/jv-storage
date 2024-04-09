package core.basesyntax;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBERS = 10;
    private Object[] keys;
    private Object[] values;
    private int count;

    public StorageImpl() {
        keys = new Object[MAX_NUMBERS];
        values = new Object[MAX_NUMBERS];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            for (int i = 0; i < count; i++) {
                if (keys[i] == null || keys[i].equals(key)) {
                    values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
