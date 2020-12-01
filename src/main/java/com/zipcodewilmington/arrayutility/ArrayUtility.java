package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
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

    public T getMostCommonFromMerge(T[] arrayToMerge) {
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
        return mostCommon.getKey();
    }


    public T[] removeValue(T valueToRemove) {
        int count = getNumberOfOccurrences(valueToRemove);
        T[] result = Arrays.copyOf(inputArray, inputArray.length - count);
        List<T> intermediate = new ArrayList<T>(Arrays.asList(inputArray));

        //Also works
//        T[] result = (T[]) Array.newInstance(valueToRemove.getClass(), intermediate.size());


        for (T i : inputArray) {
            if (i.equals(valueToRemove)) {
                intermediate.remove(i);
            }
        }


        for (int j = 0; j < result.length; j++) {
            result[j] = intermediate.get(j);
        }

        return result;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        //Declarations
        int count = 0;

        //Calculating most common value
        for (T i : inputArray) {
           if (i.equals(valueToEvaluate)) {
               count++;
           }
        }

        return count;
    }

}

