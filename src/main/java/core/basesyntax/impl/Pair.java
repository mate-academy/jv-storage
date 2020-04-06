package core.basesyntax.impl;

import java.util.Objects;

class Pair<K, V> {
    private final K key;
    private final V value;

    private Pair(K keyParam, V valueParam) {
        key = keyParam;
        value = valueParam;
    }

    public static <K, V> Pair<K, V> of(K firstValue, V secondValue) {
        return new Pair<>(firstValue, secondValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<K, V> pair = (Pair<K, V>) o;
        return Objects.equals(key, pair.key)
                && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        int value = 17;
        if (key != null) {
            value += 31 * key.hashCode();
        }
        if (this.value != null) {
            value += 31 * this.value.hashCode();
        }
        return value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
