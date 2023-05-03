import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class Employee {
    public static void main(String[] args) {
        // Creating a list of Strings
      List<String> list1 = new ArrayList<String>();
      list1.add("Rahul");
      list1.add("Sahil");
      list1.add("Rani");

        // Creating a list of Strings
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(111);
        list2.add(222);
        list2.add(333);
        list2.add(444);

        //Use of forEach
        list1.stream().forEach(System.out::println);
        list2.stream().forEach(System.out::println);

        //Use of stream.map function
        list2.stream().map(Integer::doubleValue).forEach(System.out::println);

      // Use stream.collect function
      List<Double> doubleNumbersList = list2.stream()
              .map(Integer::doubleValue)
              .collect(toList());
      System.out.println("Collected DoubleValue in New List: "+doubleNumbersList);

      //Use stream.filter function
      List<Integer> evenNumbersList = list2.stream()
              .filter(i -> i%2 == 0)
              .collect(toList());
      System.out.println("Even Numbers in List: "+evenNumbersList);

      //Use stream.findFirst function
      Optional<Integer> firstEVenNumebr = list2
              .stream().filter(i -> i%2 == 0).findFirst();
      if (firstEVenNumebr.isPresent()) {
        System.out.println("First Even Number in List: "+firstEVenNumebr.get());
      }
      else {
        System.out.println("no value");
      }

      //Use stream.min and max function
      Integer maxEvenNumber = list2.stream()
              .filter(i -> i%2 == 0)
              .collect(maxBy(Integer::compare)).get();
      System.out.println("Maximum Even Number: "+maxEvenNumber);

      Integer minEvenNumber = list2.stream()
              .filter(i -> i%2 == 0)
              .collect(minBy(Integer::compare)).get();
      System.out.println("Minimum Even Number: "+minEvenNumber);

      //find the sum and the average in the number stream - Use stream.min and
      Integer sum = list2.stream()
              .collect(summingInt(i -> i));
      System.out.println("Sum of All Values: "+sum);

      Double average = list2.stream()
              .collect(averagingDouble(i -> i));
      System.out.println("Average of All Values: "+average);

      //Use stream.allMatch and anyMatch function
      Predicate<Integer> p1 = i -> i%2 == 0;
      boolean b1 = list2.stream().anyMatch(p1);
      System.out.println("Any Even Match: "+b1);

      Predicate<Integer> p2 = i -> i%2 == 0;
      boolean b2 = list2.stream().allMatch(p2);
      System.out.println("All Even Match: "+b2);

      //Use stream.sort function
      List<Integer> sortedList = list2.stream()
              .sorted((n1, n2) -> n2.compareTo(n1))
              .collect(toList());
      System.out.println("Sorted List"+sortedList);
    }
}
