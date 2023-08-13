package core.basesyntax.impl;

class Pair<K, V> {
    private K key;
    private V value;

    //write your code here
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
        if (pair == this) {
            return true;
        }
        if (pair == null) {
            return false;
        }
        if (pair instanceof Pair) {
            Pair<K, V> currentPair = (Pair) pair;
            return ((currentPair.key == this.key)
                    || (currentPair.key != null && currentPair.key.equals(this.key)))
                    && ((currentPair.value == this.value)
                    || (currentPair.value != null && currentPair.value.equals(this.value)));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 5;
        result = 7 * result + (key == null ? 0 : key.hashCode());
        result = 7 * result + (value == null ? 0 : value.hashCode());
        return result;
    }
}
