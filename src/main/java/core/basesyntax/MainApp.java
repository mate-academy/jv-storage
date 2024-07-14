package core.basesyntax;

import core.basesyntax.impl.Box;
import core.basesyntax.impl.BoxColors;
import core.basesyntax.impl.StorageImpl;

public class MainApp {
    private static final int MAX_ARRAY_SIZE = 10;

    public static void main(String[] args) {
        int index = 0;
        Box [] boxes = new Box[MAX_ARRAY_SIZE];

        for (BoxColors colors: BoxColors.values()) {
            if (index < MAX_ARRAY_SIZE) {
                boxes[index++] = Box.createNewBox(colors);
            }
        }

        StorageImpl<Integer, Box> storage = new StorageImpl<>();
        for (int i = 0; i < boxes.length; i++) {
            storage.put(i,boxes[i]);
        }

        System.out.println(storage);
        storage.put(1,boxes[0]);
        System.out.println(storage);
        System.out.println(storage.get(8));
    }
}
