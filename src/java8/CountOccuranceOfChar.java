package java8;

import java.util.stream.Collectors;
import java.util.*;

public class CountOccuranceOfChar {
	public static void main(String args[]) {
		String str = "Cokegfviwkdhjsbvjk.,jlk.54765949mmunication";
		Map<String, Long> result = Arrays.stream(str.split("")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
		System.out.println(result);
	}
}