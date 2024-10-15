package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.List;

@RunWith(Parameterized.class)

public class LionTestParamBySex{

    @Mock
    Feline feline;

    private String sexLion;
    private boolean expectedValue;

    public LionTestParamBySex(String sexLion, boolean hasMane){
        this.sexLion = sexLion;
        this.expectedValue = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSexLion() { // это метод, который возвращает массив [][]
        return new Object[][] {
                {"Самка", false},
                {"Самец", true}
        };
    }

    @Test
    public void getSexLionReturnsFemale() throws Exception {
       // System.out.println(sexLion);
        Lion lion = new Lion(feline,sexLion);
        boolean actualValue = lion.doesHaveMane();
        Assert.assertEquals(expectedValue, actualValue);
    }


}
