package StreamJava;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class FindUniqueNos {

	public static void main(String[] args) {
		
	
		int nos[] = {1,2,3,6,7,0,6,1,3,2};
		for(int i=0;i<nos.length;i++) {
			
			for(int j=0;j<i;j++) {
				
			if(nos[i]==nos[j]) 
				
				break;
			if(i==j) 
				System.out.println(nos[i]);
			
			}
		}
	}

}
