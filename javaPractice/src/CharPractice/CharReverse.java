package CharPractice;

public class CharReverse {

	public static void main(String[] args) {
		String word= "Tamishra Senapati";
		
//		int len= word.length();
//		String rev= "";
//		
//		for(int i=len-1;i>=0;i--) {
//			
//			rev=rev+word.charAt(i);
//			//System.out.println(word.charAt(i));
//		}
//		System.out.println(rev);
		StringBuffer st= new StringBuffer(word);
		System.out.println(st.reverse());

	}

}
