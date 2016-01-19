package com.golubov.trash;

import java.util.Optional;

public class FizzBuzzBang {

    public static String getFizzBuzzBang(Integer number) {
        String fizzBuzzBang = Optional.of(number).map(num -> (num % 3 == 0 ? "Fizz" : "") + (num % 5 == 0 ? "Buzz" : "") + (num % 7 == 0 ? "Bang" : "")).get();
        return fizzBuzzBang.isEmpty() ? "Splat" : fizzBuzzBang;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getFizzBuzzBang(i));
        }
    }

}
