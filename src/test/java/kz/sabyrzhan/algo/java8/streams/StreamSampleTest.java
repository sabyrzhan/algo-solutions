package kz.sabyrzhan.algo.java8.streams;

import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamSampleTest {
    @Test
    public void testIntStream() {
        int sum = IntStream.rangeClosed(1, 100_000).sum();
        int expected = 100_000 * (1 + 100_000)/2;
        assertEquals(expected, sum);

        int min = IntStream.of(100, 200, 1321, 2, 0, 132).min().getAsInt();
        assertEquals(0, min);

        int max = IntStream.of(100, 200, 1321, 2, 0, 132).max().getAsInt();
        assertEquals(1321, max);

        long count = IntStream.rangeClosed(5, 50_000).count();
        assertEquals(49_996, count);

        IntUnaryOperator squareSumOp = val -> val * val;
        int squareSum = IntStream.rangeClosed(1, 100_000).map(squareSumOp).sum();
        System.out.println(squareSum);

        List<Integer> collect = Stream.of(1.5, 2.1, 3.2).map(Double::intValue).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testSortingStreams() {
        User[] users = {
                User.builder().age(10).name("John").surname("Allen").build(),
                User.builder().age(24).name("Marcus").surname("Oran").build(),
                User.builder().age(19).name("Wainer").surname("Aromis").build(),
                User.builder().age(27).name("Steven").surname("Wachija").build(),
                User.builder().age(33).name("John").surname("Burns").build(),
                User.builder().age(63).name("John").surname("Wane").build()
        };
        Comparator<User> userComparator = Comparator.comparing(User::getName).thenComparing(User::getSurname).reversed();
        List<User> collect = Stream.of(users).sorted(userComparator).collect(Collectors.toList());
        collect.forEach(user -> System.out.printf("%10s%10s%n", user.getName(), user.getSurname()));
    }

    @Data
    @Builder
    private static class User {
        private int age;
        private String name;
        private String surname;
    }
}
