package com.streamTest;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubLists {

    public static void main(String[] args) {
        List<String>  fruitList = Arrays.asList("apple","orange","lemon","mongo");
 //       prefixes(fruitList).forEach(System.out::println);
  //      suffixes(fruitList).forEach(System.out::println);
        of(null).forEach(System.out::println);
    }

    public static <E> Stream<List<E>> of( List<E> list) {
        assert list != null;
        return Stream.concat(Stream.of(Collections.emptyList()), prefixes(list).flatMap(SubLists::suffixes));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1,list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    private static <E> Stream < List <E >> suffixes(List < E > list) {
        return IntStream.range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }
}

