package com.zipcodewilmington.arrayutility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public <T> Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        //Declarations
        T[] merged = (T[]) new Object[arrayToMerge.length + inputArray.length];
        Map<T, Integer> map = new HashMap<>();
        int index1 = 0;
        int index2 = 0;

        //Merge
        for (int i = 0; i < merged.length; i++) {
            if (index1 < inputArray.length) {
                merged[i] = (T) inputArray[index1];
                index1++;
            } else {
                merged[i] = arrayToMerge[index2];
                index2++;
            }
        }

        //Calculating most common value
        for (T i : merged) {
            Integer value = map.get(i);
            map.put(i, value == null ? 1 : value + 1);
        }

        Map.Entry<T, Integer> mostCommon = null;

        for (Map.Entry<T, Integer> i : map.entrySet()) {
            if (mostCommon == null || i.getValue() > mostCommon.getValue()) {
                mostCommon = i;
            }
        }
        return mostCommon.getValue();

    }

    public <T> T getMostCommonFromMerge(T[] arrayToMerge) {
        //Declarations
        T[] merged = (T[]) new Object[arrayToMerge.length + inputArray.length];
        Map<T, Integer> map = new HashMap<>();
        int index1 = 0;
        int index2 = 0;

        //Merge
        for (int i = 0; i < merged.length; i++) {
            if (index1 < inputArray.length) {
                merged[i] = (T) inputArray[index1];
                index1++;
            } else {
                merged[i] = arrayToMerge[index2];
                index2++;
            }
        }

        //Calculating most common value
        for (T i : merged) {
            Integer value = map.get(i);
            map.put(i, value == null ? 1 : value + 1);
        }

        Map.Entry<T, Integer> mostCommon = null;

        for (Map.Entry<T, Integer> i : map.entrySet()) {
            if (mostCommon == null || i.getValue() > mostCommon.getValue()) {
                mostCommon = i;
            }
        }
//      return mostCommon.getValue();
        return null;
    }


    public T[] removeValue(T valueToRemove) {

        return null;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        return null;
    }
}
