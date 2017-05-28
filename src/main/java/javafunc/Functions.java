package javafunc;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Functions {

    public static List<String> _zipWith(BiFunction<String, Integer, String> f, List<String> l1, List<Integer> l2) {
        final int min;
        if ((l1 == null || l1.size() == 0) || (l2 == null || l2.size() == 0)) {
            return Collections.emptyList();
        } else {
            min = l1.size() <= l2.size() ? l1.size() : l2.size();
        }
        return IntStream.range(0, min)
                .mapToObj(i -> f.apply(l1.get(i), l2.get(i)))
                .collect(Collectors.toList());
    }

    public static <T, U, R> List<R> zipWith(BiFunction<T, U, R> f, List<T> l1, List<U> l2) {
        final int min;
        if ((l1 == null || l1.size() == 0) || (l2 == null || l2.size() == 0)) {
            return Collections.emptyList();
        } else {
            min = l1.size() <= l2.size() ? l1.size() : l2.size();
        }
        return IntStream.range(0, min)
                .mapToObj(i -> f.apply(l1.get(i), l2.get(i)))
                .collect(Collectors.toList());
    }

    public static <T, U> List<SimpleEntry<T, U>> zip(List<T> l1, List<U> l2) {
        return zipWith((t, u) -> new SimpleEntry<>(t, u), l1, l2);
    }
}
