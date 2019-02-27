
public class Rec1 {
	public static void main(String[] args) {
		System.out.println(containsVowel("Hello world!"));
		System.out.println(dateToString(1,1,2000));
		System.out.println(removeDups("aaaabbaa"));
	}
	//Checking for given character in string
	public static boolean containsVowel(String s){
		if (s.contains("a")) {
			return true;}
		if (s.contains("e")) {
			return true;} 
		if (s.contains("i")) {
			return true;}
		if (s.contains("o")) {
			return true;}
		if (s.contains("u")) {
			return true;}
		else {
			return false;
		}
	}
	// Assigning months to entered 1-12 integer
	public static String dateToString(int m, int d, int y) {
		String month = "";
		if ( m == 1) { 
			month = "January";}
		if ( m == 2) { 
			month = "February";}
		if ( m == 3) { 
			month = "March";}
		if ( m == 4) { 
			month = "April";}
		if ( m == 5) { 
			month = "May";}
		if ( m == 6) { 
			month = "June";}
		if ( m == 7) { 
			month = "July";}
		if ( m == 8) { 
			month = "August";}
		if ( m == 9) { 
			month = "September";}
		if ( m == 10) { 
			month = "October";}
		if ( m == 11) { 
			month = "November";}
		if ( m == 12) { 
			month = "December";}

		String t = month + ','+ d + ',' + y;
		return t;
	}
	//Placing all non-duplicates before characters in-place
	public static String removeDups(String s) {
		char sr[] = s.toCharArray();
		int i=1; int j=1;
		while (i<=(sr.length-1)) {
			if (sr[i]!=sr[i-1]) {
				sr[j]=sr[i];
				j=j+1;			
			}
			i=i+1;
		}
		String t = String.valueOf(sr, 0, j);
		return t;
	}
}