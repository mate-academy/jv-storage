package core.basesyntax.impl;

public class Pair<K, T> {
    private K first;
    private T second;

    private Pair(K first, T second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair<K, T> pair = (Pair<K, T>) o;
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

    public static <K, T> Pair<K, T> of(K first, T second) {
        return new Pair<>(first, second);
    }
}

