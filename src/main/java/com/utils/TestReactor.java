package com.utils;

import reactor.core.publisher.Mono;

public class TestReactor {


    public static void main(String[] args){
        Mono<String> just = Mono.just("foo");

        just.subscribe(text -> System.out.println(text));


    }

}
