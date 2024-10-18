package core.basesyntax.impl;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object pair) {
        if (this == pair) {
            return true;
        }
        if (pair == null || !pair.getClass().equals(Pair.class)) {
            return false;
        }
        Pair<K,V> current = (Pair<K,V>) pair;
        if (areObjectsEqual(getKey(), current.getKey())) {
            return false;
        }
        if (areObjectsEqual(getValue(), current.getValue())) {
            return false;
        }
        return true;
    }

    private boolean areObjectsEqual(Object forComparison, Object currentObject) {
        if (forComparison != null ? !forComparison.equals(currentObject) : currentObject != null) {
            return true;
        }
        return false;
    }

    public boolean areKeysEqual(K firstKey, K secondKey) {
        return secondKey != null && secondKey.equals(firstKey) || firstKey == secondKey;
    }
}
