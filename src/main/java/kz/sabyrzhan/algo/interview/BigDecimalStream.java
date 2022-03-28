package kz.sabyrzhan.algo.interview;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BigDecimalStream {
    public Stream<BigDecimal> preprocess(Stream<BigDecimal> input) {
        AtomicInteger counter = new AtomicInteger(0);
        return input.filter(i -> i != null && i.compareTo(BigDecimal.ZERO) > 0)
                .collect(Collectors.groupingBy(i -> counter.getAndIncrement() / 3))
                .values()
                .stream()
                .filter(i -> i.stream().collect(Collectors.averagingDouble(BigDecimal::doubleValue)) > 30)
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .stream()
                .map(i -> normalize(i))
                .filter(i -> i != null)
                .map(i -> i.flatMap(Function.identity()))
                .filter(Optional::isPresent)
                .map(Optional::get);
    }

    public Optional<Optional<BigDecimal>> normalize(BigDecimal bigDecimal) {
        return Optional.of(Optional.ofNullable(bigDecimal));
    }
}
