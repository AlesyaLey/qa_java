package com.example;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Test
    public void getSoundCat() {
        Cat cat = new Cat(new Feline());
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        Assert.assertEquals(expectedSound, actualSound);
    }

     @Mock
     Feline felineMock;

    @Test
    public void getFoodCatByFeline() throws Exception {
        Cat cat = new Cat(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Мясо"));
        Assert.assertEquals(List.of("Мясо"),cat.getFood());
    }
}
