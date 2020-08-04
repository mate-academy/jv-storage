package core.basesyntax;

public class Pair<K, V> {
    private static final int HASHCODE_NUMBER = 31;
    private K first;
    private V second;

    private Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public static <K, V> Pair<K, V> of(K first, V second) {
        return new Pair<>(first, second);
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o.getClass().equals(Pair.class))) {
            return false;
        }
        Pair<K, V> pair = (Pair<K, V>) o;
        return (first != null && first.equals(pair.first) || first == pair.first)
                && (second != null && second.equals(pair.second) || (second == pair.second));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result *= HASHCODE_NUMBER + (first != null ? first.hashCode() : 0);
        result *= HASHCODE_NUMBER + (second != null ? second.hashCode() : 0);
        return result;
    }
}
