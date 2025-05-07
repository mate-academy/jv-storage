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
        Pair<K, V> current = (Pair<K, V>) pair;
        if (areObjectsNotEqual(getKey(), current.getKey())) {
            return false;
        }
        if (areObjectsNotEqual(getValue(), current.getValue())) {
            return false;
        }
        return true;
    }

    public boolean areObjectsNotEqual(Object forComparison, Object currentObject) {
        return forComparison != null ? !forComparison.equals(currentObject) : currentObject != null;
    }
}
