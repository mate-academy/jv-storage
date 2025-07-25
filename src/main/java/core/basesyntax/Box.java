package core.basesyntax;

public class Box<T> {
    private T value;

    // Конструктор для ініціалізації значення коробки
    public Box(T value) {
        this.value = value;
    }

    // Сеттер для зміни значення
    public void setValue(T value) {
        this.value = value;
    }

    // Геттер для отримання значення
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Box{value=" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Box<?> box = (Box<?>) o;
        return (value == null && box.value == null) || (value != null && value.equals(box.value));
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}


