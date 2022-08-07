package core.basesyntax.impl;

public class KeyValueStorage {
    private Object key;
    private Object value;

    public KeyValueStorage(Builder kvBuilder) {
        this.key = kvBuilder.keyObject;
        this.value = kvBuilder.valueObject;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public static class Builder {
        private Object keyObject;
        private Object valueObject;

        public void setKeyObject(Object keyObject) {
            this.keyObject = keyObject;
        }

        public void setValueObject(Object valueObject) {
            this.valueObject = valueObject;
        }

        public KeyValueStorage build() {
            return new KeyValueStorage(this);
        }

    }
}
