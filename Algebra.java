// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(-2,3));   // 2 + 3 5
	    System.out.println(minus(7,2));  // 7 - 2 5
   		System.out.println(minus(2,7));  // 2 - 7 -5
 		System.out.println(times(3,4));  // 3 * 4 12
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 10
   		System.out.println(pow(5,3));      // 5^3 125
   		System.out.println(pow(3,5));      // 3^5 243
   		System.out.println(div(12,3));   // 12 / 3 = 4   
   		System.out.println(div(5,5));    // 5 / 5  = 1
   		System.out.println(div(25,7));   // 25 / 7 = 3
   		System.out.println(mod(25,7));   // 25 % 7 = 4
   		System.out.println(mod(120,6));  // 120 % 6  =0 
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		
		for(int i=0;i<x2;i++){
			x1++;
		}
		if(x1<=0 && x2<0){
			for(int i=0 ; i>x2; i--)
			x1--;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for(int i=0;i<x2;i++){
			x1--;
		}
		if(x1<=0 && x2<0){
			for(int i=0 ; i>x2; i--)
			x1++;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = 0;
		if(x1>0){
		for(int i=0;i<x1;i++){
			result = plus(result,x2);
		}
		}
		
		else{//(x1<0)
			x1 = minus(0,x1);
			for(int i=0;i<x1;i++){
				result = plus(result,x2);
			}
		result = minus(0,result);
		}
	return result;
	}
	

	// Returns x^n (for n >= 0) 5^3 == 5*5*5
	public static int pow(int x, int n) {
		int result=1;
		for(int i=0;i<n;i++){
			result = times(result,x);
		}
		if(n<0)
		result = 0;
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if(x2==0)
			System.out.println("cannot divide by 0");
		
		int counter=1;
		int divider=x2;
		while(pow(x1,2) >= pow(x2,2)){
			counter++;
			x2=times(divider,counter);
		}
		counter--;
		if(times(x1,x2)<0)
			counter = minus(0,counter);
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
	return minus(x1,times(x2,div(x1,x2)));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if(x<0){
			System.out.println("please choose a positive number");
		}
		int numberIsEqual = 0;
		int counter = 0;
		while(x >= numberIsEqual){
			counter++;
			numberIsEqual = pow(counter,2);
		}
		counter--;
		return counter;
	}	  	  
}