/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","isten"));  // false
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am ord Voldemort")); // false

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		String preStr1 = preProcess(str1);
		String preStr2 = preProcess(str2);
		int[] arrayStr1 = new int[27];
		int[] arrayStr2 = new int[27];
		char c;

		for(int i=0;i<preStr1.length();i++){
			c = preStr1.charAt(i);
			if(c == 32)//if c is space
			arrayStr1[26]++; //adding to array[26] +1
			else
			arrayStr1[c - 'a']++;
		}
		for(int i=0;i<preStr2.length();i++){
			c = preStr2.charAt(i);
			if(c == 32)
			arrayStr2[26]++;
			else
			arrayStr2[c - 'a']++;
		}
		for(int i=0;i<26;i++){
			if(arrayStr1[i] != arrayStr2[i])
					return false;
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	//if(str.charAt(i) >= 'A' && str.charAt(i)<= 'Z'){
	//	Character.toLowerCase(str.charAt(i));
	public static String preProcess(String str) {
		String preProcessStr = "";
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if ((c < 'a') || (c > 'z')) {
				if((c >= 'A') && (c <= 'Z')) {
					preProcessStr += (char)(c + 32);
				}
				if (c == ' ') {
				 preProcessStr += c;
				}
			}
			else {
				preProcessStr += c;
			}
		}
		return preProcessStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newString = "";
		
		for(int i=0;i<=str.length();i++){
			int index = (int)(Math.random() * str.length());
			newString=newString + str.charAt(index);
			str = str.substring(0, index)+str.substring(index+1);
			i=0;
		}

		return newString;
	}
}
