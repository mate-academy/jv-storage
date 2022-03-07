package core.basesyntax;

import java.util.Objects;

public class Pair <F, S> {
    private F first;
    private S second;

    private Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;

    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

    public static <F, S> Pair<F,S> of(F first, S second) {
        return new Pair<>(first, second);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Pair
                && Objects.equals(this.getFirst(), ((Pair) other).getFirst())
                && Objects.equals(getSecond(), ((Pair) other).getSecond());
    }
}
