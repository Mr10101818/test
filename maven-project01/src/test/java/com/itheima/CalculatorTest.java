package com.itheima;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @AfterAll
    public static void tearDown() {
        System.out.println("Teardown");
    }
    @Test
    @DisplayName("啦啦啦")
    public void testAdd() {
        // 测试正数相加
        Assertions.assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
        // 测试负数相加
        Assertions.assertEquals(-1, calculator.add(-2, 1), "-2 + 1 should equal -1");
        // 测试零相加
        Assertions.assertEquals(0, calculator.add(0, 0), "0 + 0 should equal 0");
    }

    @Test
    public void testSubtract() {
        // 测试正数相减
        Assertions.assertEquals(2, calculator.subtract(5, 3), "5 - 3 should equal 2");
        // 测试负数相减
        Assertions.assertEquals(-3, calculator.subtract(-2, 1), "-2 - 1 should equal -3");
        // 测试零相减
        Assertions.assertEquals(0, calculator.subtract(0, 0), "0 - 0 should equal 0");
    }

    @Test
    public void testMultiply() {
        // 测试正数相乘
        Assertions.assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
        // 测试负数相乘
        Assertions.assertEquals(-2, calculator.multiply(-1, 2), "-1 * 2 should equal -2");
        // 测试零相乘
        Assertions.assertEquals(0, calculator.multiply(0, 5), "0 * 5 should equal 0");
    }

    @Test
    public void testDivide() {
        // 测试正数相除
        Assertions.assertEquals(2.5, calculator.divide(5, 2), "5 / 2 should equal 2.5");
        // 测试负数相除
        Assertions.assertEquals(-2.0, calculator.divide(-4, 2), "-4 / 2 should equal -2.0");
        // 测试除以 1
        Assertions.assertEquals(5.0, calculator.divide(5, 1), "5 / 1 should equal 5.0");
        // 测试除以零，期望抛出 IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0), "Dividing by zero should throw IllegalArgumentException");
    }

    @Test
    public void testSquareRoot() {
        // 测试正数的平方根
        Assertions.assertEquals(2.0, calculator.squareRoot(4), "Square root of 4 should equal 2.0");
        // 测试零的平方根
        Assertions.assertEquals(0.0, calculator.squareRoot(0), "Square root of 0 should equal 0.0");
        // 测试负数的平方根，期望抛出 IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-1), "Square root of negative number should throw IllegalArgumentException");
    }
}