package logical;

public class CharacterFrequencyConsecutiveOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char last_removed = '\0';

		printRLE("gaaa");
//		printRLE("ccccOddEEE");
//		printRE("gaaa");

	}

	static void printRLE(String s) {
		for (int i = 0; i < s.length(); i++) {

			// Counting occurrences of s[i]
			int count = 1;
			while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				i++;
				count++;
			}
			if(count>1)
				System.out.print(count);
			else
				System.out.print(s.charAt(i) );
		}

		System.out.println();
	}
	
	
//	static void printRE(String s) {
//		int cnt = 1;
//		String res="";
//		int i=0;
//		while (i < s.length()-1) {
//			if(s.charAt(i) == s.charAt(i + 1)) {
//				cnt++;
//			}
//			else {
//				res+=s.charAt(i);
//				res+=cnt;
//			}
//			i++;
//		}
//		System.out.println(res);
//			
//		}
	}
		
		
		
		
//		for(int i=0; i<in.length(); i++){
////            System.out.println(in.charAt(i)+"----"+in.charAt(i+1));
//            if(in.charAt(i) == in.charAt(i+1)) {
//                cnt++;
//                System.out.println("if---"+i);
//            }
//            else if (in.charAt(i) != in.charAt(i+1) && in.charAt(i) == in.charAt(i-1))
//            {
//                //System.out.println(in.charAt(i)+"--222--"+in.charAt(i+1));
//                cnt++;
//                res+=cnt;
//                cnt=1;
//                System.out.println("else if---"+i);
//            }
//            else{
//                res+=in.charAt(i);
//                System.out.println("else---"+i);
//            }
//            
//        }
//        System.out.println(res);
//	}

