package core.basesyntax;

import javax.swing.Box;

import core.basesyntax.Storage;
import core.basesyntax.impl.StorageImpl;

public class MainApp {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Storage<Integer, Box> storage = new StorageImpl<>();
            Box box = new Box();
            storage.put(22 + i, box);
            Box value = storage.get(22 + i); // returns the Box
            int size = storage.size(); // returns storage size
        }

    }
}
