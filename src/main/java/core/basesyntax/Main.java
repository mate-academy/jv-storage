import core.basesyntax.Box;
import core.basesyntax.Storage;
import core.basesyntax.impl.StorageImpl;

public class Main {

    public static void main(String[] args) {
        Storage<Integer, Box> storage = new StorageImpl<>();

        Box box = new Box("Apple");
        storage.put(1, box);
        Box box2 = new Box("Banana");
        storage.put(2, box2);

        Box value = storage.get(1); // Zwróci "Apple"
        System.out.println(value.getContent());

        int size = storage.size();
        System.out.println("Size of storage: " + size);
    }
}
