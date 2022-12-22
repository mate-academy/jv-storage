package core.basesyntax.impl;

class Pair<K,V> {

    private K key;
    private V value;

    public Pair(K key,V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object pair) {
        if (pair == this) {
            return true;
        }
        if (pair == null) {
            return false;
        }
        if (pair.getClass().equals(Pair.class)) {
            Pair current = (Pair) pair;
            return this.getKey().equals(current.getKey())
                    && this.getValue().equals(current.getValue());
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 31 + (key == null ? 0 : key.hashCode());
        result = 31 + (value == null ? 0 : value.hashCode());
        return result;
    }
}
