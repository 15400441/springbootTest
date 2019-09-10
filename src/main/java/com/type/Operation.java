package com.type;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {

    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/");

    private final String symbol;
    Operation(String symbol){
        this.symbol = symbol;
    }

    private static final Map<String, Operation> stringToEnumMap = Stream.of(values()).collect(Collectors.toMap(e->e.name(),e->e));

    public static Optional<Operation> fromString(String name){
        return Optional.ofNullable(stringToEnumMap.get(name));
    }

    @Override
    public String toString(){
        return symbol;
    }


}
