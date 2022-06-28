package java8;

public class CountOccurenceOfCharacterInString {

	public static void main(String[] args) {
		String someString = "Brijesh";
		long count = someString.chars().filter(ch -> ch == 'B').count();
		System.out.println(count);
	}

}
