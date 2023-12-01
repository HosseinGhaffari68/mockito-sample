package com.spring.test.utility;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

public class UtilityTests {

    Utility utility;
    @BeforeEach
    public void init(){
        utility = new Utility();
    }

    @AfterEach
    public void shutdown(){

    }

    //min (اسم متد)
    //normal (چیزی که میخواهم بهش بدهم یک نرمال اینپوت هست)
    //normal (چیزی که از آن انتظار دارم یک نرمال اوت پوت هست)
    @Test
    public void min_normal_normal() {
        int[] array = {1, 3, 5, 8, 2, 22};
        Assertions.assertEquals(1, utility.min(array));
    }

    @Test
    public void min_empty_exception(){
        int[] array = {};
        Assertions.assertThrows(UtilityException.class, ()->utility.min(array));
    }

    @Test
    public void min_null_exception(){
        Assertions.assertThrows(UtilityException.class, ()->utility.min(null));
    }

    @Test
    public void getAnEvenNumber_normal_normal(){
        int[] array = {1, 2, 3, 5, 6};
        int result = utility.getAnEvenNumber(array);
        MatcherAssert.assertThat("result must be 2 or 6", result, anyOf(is(2), is(6)));
    }

    @Test
    public void getEvenNumbers_normal_normal(){
        int[] array = {1, 2, 3, 5, 6};
        Integer[] result = utility.getEvenNumbers(array);
        MatcherAssert.assertThat("result must be 2 and 6", result, allOf(is(2), is(6)));
    }
}
