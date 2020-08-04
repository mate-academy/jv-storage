package core.basesyntax.impl;

public class Pair<K, T> {
    private int index;
    private final K first;
    private final T second;

    private Pair(K first, T second, int index) {
        this.first = first;
        this.second = second;
        this.index = index;
    }

    public K getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;
        return (first == pair.first
                || (first != null && first.equals(pair.first)))
                && (second == pair.second
                || (second != null && second.equals(pair.second)));
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    public static <K, T> Pair<K, T> of(K first, T second, int index) {
        return new Pair<>(first, second, index);
    }
}

