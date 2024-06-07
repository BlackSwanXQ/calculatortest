package com.example.calculatortest.services;

import com.example.calculatortest.interfaces.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public String greet() {
        return "<h1> Добро пожаловать в калькулятор!</h1>";
    }

    @Override
    public String plus(Integer num1, Integer num2) {
        checkNull(num1,num2);
        int totalNum = num1 + num2;
        return "<h1>" + "%d + %d = %d".formatted(num1, num2, totalNum) + "</h1>";
    }

    @Override
    public String minus(Integer num1, Integer num2) {
        checkNull(num1, num2);
        int totalNum = num1 - num2;
        return "<h1>" + "%d - %d = %d".formatted(num1, num2, totalNum) + "</h1>";
    }

    @Override
    public String multiply(Integer num1, Integer num2) {
        checkNull(num1, num2);
        int totalNum = num1 * num2;
        return "<h1>" + "%d * %d = %d".formatted(num1, num2, totalNum) + "</h1>";
    }

    @Override
    public String divide(Integer num1, Integer num2) {
        checkNull(num1, num2);
        checkZero(num2);
        double totalNum = (double) num1 / num2;
        return "<h1>" + "%s / %s = %s".formatted(num1, num2, String.format("%.2f", totalNum)) + "</h1>";
    }




    private void checkNull(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("The parameter num1 or num2 is null!");
        }
    }

    private void checkZero(Integer num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("division by zero");
        }

    }

}
