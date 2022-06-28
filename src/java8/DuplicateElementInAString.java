package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class DuplicateElementInAString {

	public static void main(String[] args) {

        // 3, 4, 9
        List<Integer> list = Arrays.asList(1,5,9,5,3,3,6,1,9);

        Set<Integer> result = findDuplicateBySetAdd(list);
        result.forEach(System.out::println);
        
        Set<Integer> result1 = findDuplicateByGrouping(list);
        result1.forEach(System.out::println);
        
        Set<Integer> result2 = findDuplicateByFrequency(list);
        result2.forEach(System.out::println);

    }

    public static <T> Set<T> findDuplicateBySetAdd(List<T> list) {
        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n)) // Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());
    }
    
    public static <T> Set<T> findDuplicateByGrouping(List<T> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity()
                        , Collectors.counting()))    // create a map {1=1, 2=1, 3=2, 4=2, 5=1, 7=1, 9=2}
                .entrySet().stream()                 // Map -> Stream
                .filter(m -> m.getValue() > 1)       // if map value > 1, duplicate element
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
    
    public static <T> Set<T> findDuplicateByFrequency(List<T> list) {
        return list.stream().filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());

    }

}
