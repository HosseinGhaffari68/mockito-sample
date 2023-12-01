package com.spring.test.utility;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    public int fib(int n){
        if(n<0){
            throw new UtilityException("Input can not be negative!");
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    public int min(int[] array){
        if(array==null||array.length==0){
            throw new UtilityException("Empty Array");
        }
        int result = Integer.MAX_VALUE;
        for(int value:array){
            if(value<result){
                result = value;
            }
        }
        return result;
    }

    public Integer[] getEvenNumbers(int[] array){
        if(array==null||array.length==0){
            throw new UtilityException("Empty Array");
        }
        List<Integer> result = new ArrayList<>();
        for(int value:array){
            if(value%2==0){
                result.add(value);
            }
        }
        if(!result.isEmpty()){
            return result.toArray(new Integer[0]);
        }else {
            throw new UtilityException("No even number in the array!");
        }
    }

    public int getAnEvenNumber(int[] array){
        if(array==null||array.length==0){
            throw new UtilityException("Empty Array");
        }
        for(int value:array){
            if(value%2==0){
                return value;
            }
        }
        throw new UtilityException("No even number in the array!");

    }
}
