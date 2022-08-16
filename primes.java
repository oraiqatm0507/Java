import java.util.*;

public class primes {

	static boolean isPrime(int n) {
		
		//0 and 1 are not prime
		if(n==1 || n==0) return false;
		
		//check if n is divisible by another number
		for(int i=2; i< n; i++) {
			if(n%i == 0) return false;
		}
		
		//n is prime
		return true;
	}
	
	
	public static void main(String[] args)
	{
		
		int N =1000000;
		int maxPrimes =100;
		int count =0;
		
		
		for(int i =1; i<= N; i++) {
			if(count >= maxPrimes) 
				break;
			
			if(isPrime(i) ) {
				count++;
				System.out.println(i + " is Prime.");
			}
			
		}
		
		System.out.println("There are: " + count + " primes.");
			
		
	}
}
