package core.basesyntax;

import core.basesyntax.impl.StorageImplement;
import org.junit.Assert;
import org.junit.Test;

public class StorageImplTest {

    @Test
    public void addElementsToStorage() {
        Storage<Integer, String> storage = new StorageImplement<>();
        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";

        storage.put(1, elementOne);
        storage.put(2, elementTwo);
        storage.put(3, elementTree);

        Assert.assertEquals("With three elements added to the storage, its size should be 3",
                3, storage.size());
        Assert.assertEquals(elementOne, storage.get(1));
        Assert.assertEquals(elementTwo, storage.get(2));
        Assert.assertEquals(elementTree, storage.get(3));
    }

    @Test
    public void getElementWhenKeyDontExist() {
        Storage<Integer, String> storage = new StorageImplement<>();

        Assert.assertNull(
                "When element with this key doesn't exist, the method should return \"null\"",
                storage.get(1234321));
    }

    @Test
    public void getElementWithKeyNull() {
        Storage<Integer, String> storage = new StorageImplement<>();
        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";
        String elementFour = "Element 4";
        storage.put(1, elementOne);
        storage.put(null, elementTwo);
        storage.put(3, elementTree);
        storage.put(4, elementFour);
        Assert.assertEquals(
                "Test failed! Method get(null) should return value",
                elementTwo,
                storage.get(null));
        Assert.assertEquals(
                "Test failed! Method get(key) should return value",
                elementOne,
                storage.get(1));
        Assert.assertEquals(
                "Test failed! Method get(key) should return value",
                elementTree,
                storage.get(3));
        Assert.assertEquals(
                "Test failed! Method get(key) should return value",
                elementFour,
                storage.get(4));
    }

    @Test
    public void getElementWhenKeyIsObject() {
        Storage<Cat, String> storage = new StorageImplement<>();
        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";
        Cat firstCat = new Cat("Myrchyk", "white");
        Cat secondCat = new Cat("Barsik", "black");
        Cat thirdCat = new Cat("Musia", "grey");

        storage.put(firstCat, elementOne);
        storage.put(secondCat, elementTwo);
        storage.put(thirdCat, elementTree);
        Cat sameSecondCat = new Cat("Barsik", "black");

        Assert.assertEquals(
                "Test failed! Method get(key) should return correct value",
                elementTwo, storage.get(sameSecondCat));
    }

    @Test
    public void addTwoElementsWithSameKey() {
        Storage<Cat, String> storage = new StorageImplement<>();
        Cat cat = new Cat("Myrchyk", "white");
        Cat sameCat = new Cat("Myrchyk", "white");
        String elementOne = "One";
        String elementTwo = "Two";

        storage.put(cat, elementOne);
        storage.put(sameCat, elementTwo);

        Assert.assertEquals(
                "With two elements added with the same key, "
                        + "the value should be rewritten",
                elementTwo,
                storage.get(cat));
        Assert.assertEquals("With two elements added with the same key, "
                        + "the storage size should be 1",
                1, storage.size());
    }

    @Test
    public void addTwoElementsWithNullKey() {
        Storage<Cat, String> storage = new StorageImplement<>();
        String elementOne = "One";
        String elementTwo = "Two";

        storage.put(null, elementOne);
        storage.put(null, elementTwo);

        Assert.assertEquals(
                "With two elements added with the same \"null\" key, "
                        + "the value should be rewritten",
                elementTwo,
                storage.get(null));
        Assert.assertEquals("With two elements added with the same \"null\" key, "
                        + "the storage size should be 1",
                1, storage.size());
    }
}
