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

    public void setValue(V value) {
        this.value = value;
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
        if (getKey() != null ? !getKey().equals(current.getKey()) : current.getKey() != null) {
            return false;
        }
        if (getValue() != null ? !getValue().equals(current.getValue()) :
                current.getValue() != null) {
            return false;
        }
        return true;
    }
}
