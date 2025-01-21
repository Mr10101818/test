package com.itheima;

public class Calculator  {
    // 加法方法
public int add(int a, int b) {
    return Math.addExact(a, b);
}


    // 减法方法
    public int subtract(int a, int b) {
        return a - b;
    }

    // 乘法方法
    public int multiply(int a, int b) {
        return a * b;
    }

    // 除法方法
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    // 平方根方法，只对非负整数有效
    public double squareRoot(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(a);
    }
}