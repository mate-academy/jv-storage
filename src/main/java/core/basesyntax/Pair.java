package core.basesyntax;

public class Pair<T, G> {
    private T key;
    private G value;

    public Pair(T key, G value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public G getValue() {
        return value;
    }

    public void setValue(G value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object pair) {
        if (pair == null) {
            return false;
        }

        if (pair == this) {
            return true;
        }

        if (pair.getClass() == Pair.class) {
            Pair other = (Pair) pair;
            boolean isKeyEquals = this.key == null ? other.key == null : this.key.equals(other.key);
            boolean isValueEquals = this.value == null
                          ? other.value == null
                          : this.value.equals(other.value);
            if (isKeyEquals && isValueEquals) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 37;
        if (key != null) {
            result += result * 17 + key.hashCode();
        }

        if (value != null) {
            result += result * 19 + value.hashCode();
        }
        return result;
    }
}
