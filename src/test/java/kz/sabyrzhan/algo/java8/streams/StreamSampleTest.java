package kz.sabyrzhan.algo.java8.streams;

import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamSampleTest {
    @Test
    void testIntStream() {
        int sum = IntStream.rangeClosed(1, 100_000).sum();
        int expected = 100_000 * (1 + 100_000) >> 1;
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
    void testSortingStreams() {
        Comparator<User> userComparator = Comparator.comparing(User::getName).thenComparing(User::getSurname);
        List<User> collect = Stream.of(createUsers()).sorted(userComparator).toList();
        collect.forEach(user -> System.out.printf("%10s%10s%n", user.getName(), user.getSurname()));
    }

    @Test
    void testGroupingOfStreams() {
        Map<String, List<User>> mapCollect = Stream.of(createUsers()).collect(Collectors.groupingBy(User::getName));
        mapCollect.forEach((s, users) -> {
            System.out.println(s);
            users.forEach(user -> System.out.printf("%10s%10s%n", user.getName(), user.getSurname()));
        });
    }

    @Test
    void testToMapOfStreams() {
        System.out.println("All users");
        // if we have duplicate keys, we have to create merger functions or just return the last one
        BinaryOperator<User> merger = (user, user2) -> user2;
        Collector<User, ?, Map<String, User>> collector = Collectors.toMap(User::getName, Function.identity(), merger);
        Map<String, User> collect = Stream.of(createUsers()).collect(collector);
        collect.forEach((s, user) -> System.out.printf("%10s%10s%n", user.getName(), user.getSurname()));
    }

    @Test
    void testFlatMapOfStreams() {
        AtomicInteger i = new AtomicInteger(0);
        Stream.of(createUsers()).flatMap(user -> {
            // Generate stream of numbers
            IntStream intStream = IntStream.rangeClosed(i.get(), i.get() + 10);
            i.addAndGet(500);
            return intStream.boxed();
        }).forEach(integer -> System.out.println(" -> " + integer));
    }

    private static User[] createUsers() {
        return new User[]{
                User.builder().age(10).name("John").surname("Allen").build(),
                User.builder().age(24).name("Marcus").surname("Oran").build(),
                User.builder().age(19).name("Wainer").surname("Aromis").build(),
                User.builder().age(27).name("Steven").surname("Wachija").build(),
                User.builder().age(33).name("John").surname("Burns").build(),
                User.builder().age(63).name("John").surname("Wane").build()
        };
    }

    @Data
    @Builder
    private static class User {
        private int age;
        private String name;
        private String surname;
    }
}
