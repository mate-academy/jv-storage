package core.basesyntax.impl;

@SuppressWarnings("unchecked")
public class StorageData<K, S> {

    private final int initialCapacity = 10;
    private final Object[] keys = new Object[initialCapacity];
    private final Object[] values = new Object[initialCapacity];
    private final int defaultIndex = 0;
    private int index = 1;

    void setKeysAndValue(K key, S value) {
        if (key == null) {
            values[defaultIndex] = value;
            return;
        }
        for (int i = 1; i < index; i++) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index++] = value;
    }

    S getByKeys(K key) {
        if (key == null) {
            return (S) values[defaultIndex];
        }
        for (int i = 1; i <= index; i++) {
            if (key.equals(keys[i])) {
                return (S) values[i];
            }
        }
        return null;
    }

    int getSizeOfArray() {
        if (keys[1] == null && values[defaultIndex] != null) {
            return 1;
        }
        return index - 1;
    }
}
