package core.basesyntax.impl;

class Pair<T, Z> {
    private T first;
    private Z second;

    private Pair(T first, Z second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public Z getSecond() {
        return second;
    }

    public static <T, Z> Pair<T, Z> of(T first, Z second) {
        return new Pair<>(first, second);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Pair newPair = (Pair) obj;
        return ((first == newPair.first)
                    || (first != null && first.equals(newPair.first)))
                && ((second == newPair.second)
                    || (second != null && second.equals(newPair.second)));
    }

    @Override
    public int hashCode() {
        int code = 11;
        code = 17 * code + (first == null ? 0 : first.hashCode());
        code = 17 * code + (second == null ? 0 : second.hashCode());
        return code;
    }
}
