package CharPractice;

public class CharCount {

	public static void main(String[] args) {
		
		String str="afhjgaghf";
		char[] c= str.toCharArray();
		int len= c.length;
		int count=0;
		
		for(int i=0;i<len;i++) {
			
			for(int j=0;j<len;j++) {
				
				if(j<i && c[i]==c[j]) {
					break;
				}
				if(c[j]==c[i]) {
					count++;
				}
				if(j==len-1) {
					System.out.println("the character "+c[i]+" is present "+count+" times.");
				}
			}
		}

	}

}
