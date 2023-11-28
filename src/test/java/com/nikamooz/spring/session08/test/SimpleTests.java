package com.nikamooz.spring.session08.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class SimpleTests {

    @Spy
    List<String> list;

    @Captor
    ArgumentCaptor<Collection<String>> argumentCaptor;


    @Test
    public void testList(){
        ArrayList<String> sublist = new ArrayList<String>();
        sublist.add("Iran");
        sublist.add("Country");
        list.addAll(sublist);
        Mockito.verify(list).addAll(argumentCaptor.capture());
        Collection<String> value = argumentCaptor.getValue();
        Assertions.assertEquals(sublist, value);
    }


}
