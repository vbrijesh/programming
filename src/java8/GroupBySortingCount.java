package java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBySortingCount {

	public static void main(String[] args) {

		// 3 apple, 2 banana, others 1
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		// Group by
		Map<String, Long> result = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(result);

		Map<String, Long> finalMap = new LinkedHashMap<>();

		// Sort a map and add to finalMap
		result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println(finalMap);

		// Examples to ‘group by’ a list of user defined Objects.
		List<Item> items1 = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")), new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));

//		Map<String, Long> counting = items.stream()
//				.collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
//
//		System.out.println(counting);
//
//		Map<String, Integer> sum = items.stream()
//				.collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
//
//		System.out.println(sum);
//
//		Map<BigDecimal, List<Item>> groupByPriceMap = items.stream().collect(Collectors.groupingBy(Item::getPrice));
//
//		System.out.println(groupByPriceMap);
//
//		// group by price, uses 'mapping' to convert List<Item> to Set<String>
//		Map<BigDecimal, Set<String>> result1 = items.stream()
//				.collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));
//
//		System.out.println(result);

		Map<String, Integer> wordCounts = new HashMap<>();
		wordCounts.put("USA", 100);
		wordCounts.put("jobs", 200);
		wordCounts.put("software", 50);
		wordCounts.put("technology", 70);
		wordCounts.put("opportunity", 200);

		// Sort the map based on the value in ascending order
		Map<String, Integer> sortedMap = wordCounts.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(sortedMap);

		// Sort the map based on value in desending order

		Map<String, Integer> sortedMapReverseOrder = wordCounts.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(sortedMapReverseOrder);
		
		// https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values
	}
}

class Item {

	public Item(String string, int i, BigDecimal bigDecimal) {
		// TODO Auto-generated constructor stub
	}

	private String name;
	private int qty;
	private BigDecimal price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
