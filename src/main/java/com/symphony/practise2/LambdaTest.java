package com.symphony.practise2;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class LambdaTest {
    public static void main(String[] args) {
        IntUnaryOperator function = t -> t * 10;
        System.out.println(function.applyAsInt(5));
    }
}
