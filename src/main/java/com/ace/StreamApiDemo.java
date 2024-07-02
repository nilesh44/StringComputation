package com.ace;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiDemo {


    public static void main(String[] args) {

       // what is stream ?
        // A Stream represents a sequence of elements and supports
       // various operations to perform computations on these elements.

        //intermediate operations is designed to perform an operation on
        //stream and then return a new stream for further operation e.g filter method
        //Intermediate operations are not executed until some terminal operation is invoked.

        //terminal operation are the operations which  will not provide any
        //stream instead it will provide end object e.g collect, anyMatch

        //stream -> intermediate operation ---> treminal operation

        //filter method intermediate operations
        //same as where clause in sql
       List<String> filtered= Arrays.asList("anil","sunil","sanjay","rahul")
                .stream()//create stream
                .filter((name)->name.startsWith("s")) //intermediate operation
                .collect(Collectors.toList()); //terminal operation that provide list object

        System.out.println(filtered);
        //[sunil, sanjay]
        Arrays.asList("anil","sunil","sanjay","rahul")
                .stream()
                .anyMatch((name)->name.equals("anil"));

        //sorting in ascending , natural sorting order
        System.out.println(
                Arrays.asList(1,3,6,5,4,7,8,9,10,20,15)
                .stream().sorted().collect(Collectors.toList()));

        //sorting in descending , natural sorting order
        System.out.println(Arrays.asList(1,3,6,5,4,7,8,9,10,20,15)
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));

        //merge two stream
        System.out.println(Stream
                .concat(
                        Arrays.asList(1,3,6,5,4,7,8,9,10,20,15).stream(),
                Arrays.asList(1,3,6,5,4,7,8,9,10,20,15).stream())
                .collect(Collectors.toList()));

        //map method
        // it is used when we want to perform operation on object and transform into another form
        System.out.println( Arrays.asList("apple","mango","banana","orange")
                .stream()
                .map((fruit)->fruit.toUpperCase())
                .collect(Collectors.toList()));
        //[APPLE, MANGO, BANANA, ORANGE]

        //tomap
        //it is used to get map from stream
        System.out.println( Arrays.asList("mumbai","banglor","pune","kolkata","uk")
                .stream()
                .collect(Collectors.toMap(name->name,name->name.length())));

        //groupingBy
        //it is same as groupby in sql , here we can collect stream on the basis of group
        System.out.println(  Arrays.asList("mumbai","banglor","pune","kolkata","uk")
                .stream()
                .collect(Collectors.groupingBy(name->name.length())));
      //  {2=[uk], 4=[pune], 6=[mumbai], 7=[banglor, kolkata]}

        //partitionby
        // is use divide stream into two stream on the basis of a condition
        Map<Boolean, List<String>> partitionedByLength = Arrays
                .asList("mumbai","banglor","pune","kolkata","uk")
                .stream()
                .collect(Collectors.partitioningBy(name -> name.length() > 3));
        System.out.println(partitionedByLength);
       // {false=[uk], true=[mumbai, banglor, pune, kolkata]}



    }
}
