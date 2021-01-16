package com.monpro.generics.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayUtilsTest {
    @Test
    void skipToLastIndexTest() {
        int[] nums = new int[]{2,3,1,1,4};
        assertEquals(ArrayUtils.skipToLastIndex(nums), true);
        nums = new int[]{3,2,1,0,4};
        assertEquals(ArrayUtils.skipToLastIndex(nums), false);
        assertEquals(ArrayUtils.skipToLastIndex(new int[]{}), true);
    }

    @Test
    void minStepsToLastIndexTest() {
        int[] nums = new int[]{2,3,1,1,4};
        assertEquals(ArrayUtils.minStepsToLastIndex(nums), 2);
        nums = new int[]{3,2,1,0,4};
        assertEquals(ArrayUtils.minStepsToLastIndex(nums), 2);
        nums = new int[]{2,6,1,0,4,5,4};
        assertEquals(ArrayUtils.minStepsToLastIndex(nums), 2);
    }

    @Test
    void canReachToIndexWithValueZero() {
        int[] nums = new int[]{4,2,3,0,3,1,2};
        int start = 5;
        assertEquals(ArrayUtils.canReachToIndexWithValueZero(nums, start), true);
        nums = new int[]{4,2,3,0,3,1,2};
        start = 0;
        assertEquals(ArrayUtils.canReachToIndexWithValueZero(nums, start), true);
        nums = new int[]{3,0,2,1,2};
        start = 2;
        assertEquals(ArrayUtils.canReachToIndexWithValueZero(nums, start), false);
    }

    @Test
    void shortestPathInBinaryMatrixTest() {
        assertEquals(ArrayUtils.shortestPathInBinaryMatrix(new int[][]{{0, 1}, {1, 0}}), 2);
        assertEquals(ArrayUtils.shortestPathInBinaryMatrix(new int[][]{{1, 1}, {1, 0}}), -1);
        assertEquals(ArrayUtils.shortestPathInBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}), 4);
        assertEquals(ArrayUtils.shortestPathInBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}}), -1);
    }

    @Test
    void getSumOfDiagonalTest(){
        assertEquals(ArrayUtils.getSumOfDiagonal(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}), 25);
        assertEquals(ArrayUtils.getSumOfDiagonal(new int[][]{{7}}), 7);
        assertEquals(ArrayUtils.getSumOfDiagonal(new int[][]{{1, 2}, {3, 4}}), 10);
    }

}
