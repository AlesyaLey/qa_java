package com.example;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.Exception;
import java.util.List;

//нужно параметризировать этот тест для самки и самци!!!!!!!!+++ обработка исключения

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getSexLionReturnsFemale() throws Exception {
        Lion lion = new Lion(feline,"Самка");
        boolean expectedValue = false;
        boolean actualValue = lion.doesHaveMane();
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getSexLionReturnsMale() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        boolean expectedValue = true;
        boolean actualValue = lion.doesHaveMane();
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test(expected = Exception.class)
    public void getSexLionReturnsException() throws Exception {
        Lion lion;
        String expectedValue = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = null;
        try {
            new Lion(feline,"ОНО");
        } catch (Exception ex) {
            exception = ex;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals(expectedValue, exception.getMessage());
    }

    @Test
    public void getFoodLionForFemale() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFoodLionForMale() throws Exception {
        Lion lion = new Lion(feline,"Самка");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getKittensMale() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectCount = 1;
        int actualCount = lion.getKittens();
        Assert.assertEquals(expectCount, actualCount);
    }

    @Test
    public void getKittensFemale() throws Exception {
        Lion lion = new Lion(feline,"Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectCount = 1;
        int actualCount = lion.getKittens();
        Assert.assertEquals(expectCount, actualCount);
    }

}
