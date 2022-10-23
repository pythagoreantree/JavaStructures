package util.implementations.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.collections.implementations.array.dynamic.DynamicArray;

class DynamicArrayTest {

    @Test
    void add() {
        DynamicArray<Integer> dArray = new DynamicArray<Integer>(Integer.class);
        Assertions.assertTrue(dArray.isEmpty());

        dArray.add(1);
        Assertions.assertEquals(1, dArray.size());
    }
}