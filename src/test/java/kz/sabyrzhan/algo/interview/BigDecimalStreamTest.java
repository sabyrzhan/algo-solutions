package kz.sabyrzhan.algo.interview;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalStreamTest {
    BigDecimalStream big = new BigDecimalStream();

    @Test
    void test1() {
        Stream<BigDecimal> stream = Stream.of(BigDecimal.ONE, BigDecimal.ZERO, new BigDecimal(10), new BigDecimal(1));
        var result = big.preprocess(stream);
        result.forEach(System.out::println);
    }
}