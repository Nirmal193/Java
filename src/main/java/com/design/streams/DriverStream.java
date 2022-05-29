package com.design.streams;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

public class DriverStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("nirmal");
        getStream(list).forEach(System.out::println);
        String arrString[] = new String[9];
        arrString[0] = "ritu";
        Arrays.stream(arrString).limit(1).forEach(System.out::println);
        Stream.builder().add("nihar").add("ritu").build().forEach(System.out::println);
        //sequence of elements
        Stream<String> generated = Stream.generate(()->"some random string for generator").limit(5);
        generated.forEach(System.out::println);
       // Stream.iterate(1,i->i+2).limit(5).forEach(System.out::println);
        IntStream intStream = IntStream.range(1,5);
        LongStream longStream = LongStream.range(1,6);
       // intStream.forEach(System.out::println);
        Random ranodm = new Random();
        DoubleStream doubleStream = ranodm.doubles(4);
        doubleStream.forEach(System.out::print);
        String str =  "Nirmal";
        IntStream intStream1 = str.chars();
        intStream1.forEach(System.out::print);
        System.out.println();
        Pattern.compile(",").splitAsStream("mukesh").forEach(System.out::println);
        Stream<String> stringStream = Stream.of("nirmal","likes","ritu").filter(x->x.contains("nirmal"));
        Optional<String> optional = stringStream.findAny();
        System.out.println(optional.get());
        Stream.of("nirmal","nihar","ritu").skip(2).map(x->x.substring(2)).forEach(System.out::print);
        //The vorder of the execution starts from the right order so if a skip() is present after the map
        //in those cases the map is gonna called that much time as the number is provided in the skip method
        //so the order of the methods in the stream is much more important
        System.out.println();
        OptionalInt a1 = IntStream.of(1,2,3).reduce((a,b)->(a+b));
        System.out.println(a1.getAsInt());
        int a2 = IntStream.range(1,5).reduce(10,(a,b)->(a+b));
        System.out.println(a2);
        int a3 = IntStream.range(1,5).reduce(10, (a, b) -> {
            return a + b;
        });
        System.out.println(a3);
        List<String> productLists = Arrays.asList(new String("potatoes"),
                new String("orange"), new String("lemon"),
                new String("bread"), new String("sugar"));
        System.out.println(productLists.stream().collect(Collectors.joining(",","[","]")));
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));
        int summingPrice = productList.stream()
                .collect(Collectors.summingInt(Product::getPrice));
        System.out.println("summing price -> "+summingPrice);
        IntSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingInt(Product::getPrice));
        System.out.println("statics :: " + statistics.getCount() + "------>" + statistics.getMax());
        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));

        Map<Boolean, List<Product>> mapPartioned = productList.stream()
                .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        Collections::unmodifiableSet));
    }
    public static Stream getStream( List list){
        if(list == null || CollectionUtils.isEmpty(list))
            return Stream.empty();
        else
            return list.stream();
    }
}
