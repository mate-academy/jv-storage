package core.basesyntax.impl;

import java.util.Objects;

class Pair<K, V> {
    private final K key;
    private final V value;

    private Pair(K keyParam, V valueParam) {
        key = keyParam;
        value = valueParam;
    }

    public static <K, V> Pair of(K firstValue, V secondValue) {
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
        Pair<K, V> pair = (Pair) o;
        return Objects.equals(key, pair.key)
                && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (key != null) {
            result = 31 * result + key.hashCode();
        }
        if (value != null) {
            result = 31 * result + value.hashCode();
        }
        return result;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
