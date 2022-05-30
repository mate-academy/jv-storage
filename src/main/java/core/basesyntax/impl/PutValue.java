package core.basesyntax.impl;

public class PutValue<K, V> {
    private K key;
    private V value;
    private int size;
    private Object[] keys;
    private Object[] values;

    public PutValue(K key, V value, Object[] keys, Object[] values) {
        this.key = key;
        this.value = value;
        this.keys = keys;
        this.values = values;
        this.size = size;
        put(this.key, this.value, this.keys, this.values, this.size);
    }

    private void put(K key, V value, Object[] keys, Object[] values, int size) {
        for (int i = 0; i < keys.length; i++) {
            if ((values[i] == null)
                    || (key == keys[i] && values[i] != null)
                    || ((key == keys[i]) || (key != null && key.equals(keys[i])))) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }

    }
}
