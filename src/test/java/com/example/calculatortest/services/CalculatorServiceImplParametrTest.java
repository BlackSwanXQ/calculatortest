package com.example.calculatortest.services;

import com.example.calculatortest.interfaces.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



import java.util.stream.Stream;


public class CalculatorServiceImplParametrTest {


    private CalculatorService calculatorService;

    @BeforeEach
    void setCalculatorService() {
        calculatorService = new CalculatorServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("provideParamsForGreetTest")
    void greet(String expected) {
        Assertions.assertEquals(expected, calculatorService.greet());
    }

    public static Stream<Arguments> provideParamsForGreetTest() {
        return Stream.of(Arguments.of("<h1> Добро пожаловать в калькулятор!</h1>"));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPlusTest")
    void plusTestForValues(Integer num1, Integer num2, String result) {
        Assertions.assertEquals(result, calculatorService.plus(num1, num2));
    }

    public static Stream<Arguments> provideParamsForPlusTest() {
        return Stream.of(
                Arguments.of(2, 2, "<h1>2 + 2 = " + 4 + "</h1>"),
                Arguments.of(-4, 0, "<h1>-4 + 0 = " + (-4) + "</h1>"),
                Arguments.of(1, 5, "<h1>1 + 5 = " + 6 + "</h1>")
                );
    }


    @ParameterizedTest
    @MethodSource("provideParamsForPlusNullPointerTest")
    void plusTestForExceptions(Integer num1, Integer num2) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.plus(num1, num2));
    }

    public static Stream<Arguments> provideParamsForPlusNullPointerTest() {
        return Stream.of(
                Arguments.of(null, 1),
                Arguments.of(6, null),
                Arguments.of(null, null)
        );
    }

    /////////////////////////////////////////////////////////
    @ParameterizedTest
    @MethodSource("provideParamsForMinusTest")
    void minusTestForValues(Integer num1, Integer num2, String result) {
        Assertions.assertEquals(result, calculatorService.minus(num1, num2));
    }

    public static Stream<Arguments> provideParamsForMinusTest() {
        return Stream.of(
                Arguments.of(2, 2, "<h1>2 - 2 = " + 0 + "</h1>"),
                Arguments.of(-4, 0, "<h1>-4 - 0 = " + (-4) + "</h1>"),
                Arguments.of(1, 5, "<h1>1 - 5 = " + -4 + "</h1>")
        );
    }


    @ParameterizedTest
    @MethodSource("provideParamsForMinusNullPointerTest")
    void minusTestForExceptions(Integer num1, Integer num2) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.minus(num1, num2));
    }

    public static Stream<Arguments> provideParamsForMinusNullPointerTest() {
        return Stream.of(
                Arguments.of(null, 1),
                Arguments.of(6, null),
                Arguments.of(null, null)
        );
    }
    //////////////////////////////////////////////
    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTest")
    void multiplyTestForValues(Integer num1, Integer num2, String result) {
        Assertions.assertEquals(result, calculatorService.multiply(num1, num2));
    }

    public static Stream<Arguments> provideParamsForMultiplyTest() {
        return Stream.of(
                Arguments.of(2, 2, "<h1>2 * 2 = " + 4 + "</h1>"),
                Arguments.of(-4, 0, "<h1>-4 * 0 = " + 0 + "</h1>"),
                Arguments.of(1, 5, "<h1>1 * 5 = " + 5 + "</h1>")
        );
    }


    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyNullPointerTest")
    void multiplyTestForExceptions(Integer num1, Integer num2) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.multiply(num1, num2));
    }

    public static Stream<Arguments> provideParamsForMultiplyNullPointerTest() {
        return Stream.of(
                Arguments.of(null, 1),
                Arguments.of(6, null),
                Arguments.of(null, null)
        );
    }
    //////////////////////////////////////////////////////////////////
    @ParameterizedTest
    @MethodSource("provideParamsForDivideTest")
    void divideTestForValues(Integer num1, Integer num2, String result) {
        Assertions.assertEquals(result, calculatorService.divide(num1, num2));
    }

    public static Stream<Arguments> provideParamsForDivideTest() {
        return Stream.of(
                Arguments.of(2, 2, "<h1>2 / 2 = " + "1,00" + "</h1>"),
                Arguments.of(-4, 2, "<h1>-4 / 2 = " + "-2,00" + "</h1>"),
                Arguments.of(9, 3, "<h1>9 / 3 = " + "3,00" + "</h1>")
        );
    }


    @ParameterizedTest
    @MethodSource("provideParamsForDivideNullPointerTest")
    void divideTestForExceptions(Integer num1, Integer num2) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(num1, num2));
    }

    public static Stream<Arguments> provideParamsForDivideNullPointerTest() {
        return Stream.of(
                Arguments.of(null, 1),
                Arguments.of(6, null),
                Arguments.of(null, null)
        );
    }
}











