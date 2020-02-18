package algorism;

import java.util.*;

public class Main {
	public static void main(String[] args) {
       Scanner ix = new Scanner(System.in);
        String str = ix.nextLine();
        str = str.trim();
        int sum = 0;
        for(int i=0; i<str.length();i++){
            
            if(str.charAt(i)==' '){
                
                sum = sum+1;    
                
                
            }
        }
        if(str.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(sum+1);
        }
            
        
        
	

	}
}