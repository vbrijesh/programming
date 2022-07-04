package logical;
/**
 * 1
 * 23
 * 456
 * 78910
 * 
 * @author verma
 *
 */
public class LineBreakerPyramid {
	public static void main(String... k) {
		int linebreak = 1;
		int counter = 0;
		for(int i = 1; i <= 10; i++) {
//			System.out.println(i + "---" + linebreak +"---" +counter);
		  if(linebreak == counter++){
		    System.out.print("\n");
		    linebreak++;
		    counter = 1;
		  }
		  System.out.print(i);
		}

		
	}

}
