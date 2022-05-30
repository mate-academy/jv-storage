package core.basesyntax.impl;

public class GetValue<K, V> {
    private K key;
    private Object[] keys;
    private Object[] values;

    public GetValue(K key, Object[] keys, Object[] values) {
        this.key = key;
        this.keys = keys;
        this.values = values;
    }

    public V valueOf() {
        return get(key, keys, values);
    }

    private V get(K key, Object[] keys, Object[] values) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null && keys[i] == null) || ((key != null) && (key.equals(keys[i])))) {
                return (V) values[i];
            }
        }
        return null;
    }
}
