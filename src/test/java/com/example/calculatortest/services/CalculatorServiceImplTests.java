package com.example.calculatortest.services;

import com.example.calculatortest.interfaces.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceImplTests {
    private CalculatorService calculatorService;

    @BeforeEach
    void setCalculatorService() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void shouldReturnGreet() {
        String result = calculatorService.greet();
        Assertions.assertEquals("<h1> Добро пожаловать в калькулятор!</h1>", result );
    }

    @Test
    public void plusShouldReturnFour() {
        String result = calculatorService.plus(2, 2);
        Assertions.assertEquals("<h1>2 + 2 = " + 4 + "</h1>", result);
    }

    @Test
    public void plusShouldReturnMinusOne() {
        String result = calculatorService.plus(-3, 2);
        Assertions.assertEquals("<h1>-3 + 2 = " +(-1) + "</h1>", result);
    }

    @Test
    public void minusShouldReturnOne() {
        String result = calculatorService.minus(3, 2);
        Assertions.assertEquals("<h1>3 - 2 = " + 1 + "</h1>", result);
    }
    @Test
    public void minusShouldReturnTwo() {
        String result = calculatorService.minus(4, 2);
        Assertions.assertEquals("<h1>4 - 2 = " + 2 + "</h1>", result);
    }

    @Test
    public void MultiplyShouldReturnEight() {
        String result = calculatorService.multiply(4, 2);
        Assertions.assertEquals("<h1>4 * 2 = " + 8 + "</h1>", result);
    }
    @Test
    public void MultiplyShouldReturn0() {
        String result = calculatorService.multiply(4, 0);
        Assertions.assertEquals("<h1>4 * 0 = " + 0 + "</h1>", result);
    }

    @Test
    public void divideShouldReturnThree() {
        String result = calculatorService.divide(9, 3);
            Assertions.assertEquals("<h1>9 / 3 = " + String.format("%.2f",3.00) + "</h1>", result);
    }
    @Test
    public void divideShouldReturn0() {
        String result = calculatorService.divide(0, 3);
        Assertions.assertEquals("<h1>0 / 3 = " + String.format("%.2f",0.00) + "</h1>", result);
    }

    @Test
    public void divideByZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(2, 0));
    }

}
