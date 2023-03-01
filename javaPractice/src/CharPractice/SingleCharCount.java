package CharPractice;

public class SingleCharCount {

	public static void main(String[] args) {
		
		String str="abcdda";
		char c='d';
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==c) {
				count++;
			}
			
			
		}
		System.out.println("the character d counts "+count+" times.");

	}

}
