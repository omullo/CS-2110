import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/** This class contains methods to illustrate the use of Collection Frameworks'<br>
 * classes ArrayList, HashSet, and HashMap.<br>
 *
 * Parameter s of each method contains a sequence of words. A word is a sequence<br>
 * of non-blank characters, and adjacent words are separated by one or more blanks.<br>
 *
 * We also use function String.split, so that students become aware of it.
 *
 * For some problems, we provide more than one solution, */

public class Rec4 {
	/** Return a list of words in s. */
	public static ArrayList<String> createList1(String s) {
		// This is the most cumbersome implementation, not making use
		// of Java's classes. It has a single loop, each iteration of which
		// processes one word of s, deleting it from s.
		// Below, the "invariant" is simply a definition of
		// what's true before and after each iteration of the loop.
		s= s.trim();  // remove surrounding blanks in s.
		ArrayList<String> myList= new ArrayList<>();

		// invariant:
		// ... s contains the words of the original s that haven't been processed.
		// ... if s is not empty, s[0] is the first char of a word,
		// ... Processed words appear in myList.
		while (0 < s.length()) {
			int k= s.indexOf(' '); // k = -1 if no blanks after word
			if (k < 0) k= s.length(); // Ensure that k-1 is index of last char in word
			myList.add(s.substring(0, k));
			s= s.substring(k).trim();
		}

		return myList;
	}

	/** Return a list of words in s. */
	public static ArrayList<String> createList2(String s) {
		// This second implementation for creating a list of words uses method
		// s.split. With argument " ", the method creates an array of words that
		// are separated by blanks. That's just what we want!
		// Don't try it with other arguments until you fully understand the spec
		// of method split.
		String[] b= s.split(" ");
		// b contains all the words in s. b.length = number of words in s

		ArrayList<String> myList= new ArrayList<>();

		// Use a foreach loop to add each word in array b to myList.
		for (String w : b) {
			myList.add(w);
		}

		return myList;
	}

	/** Return the set of words in s. */
	public static HashSet<String> createSet1(String s) {
		// Store in b an array of words in s. There can be duplicates.
		String[] b= s.split(" ");

		HashSet<String> words= new HashSet<>();

		// Use a foreach loop to process elements of array b.
		for (String w : b) {
			// The following statement will add w to the set if w
			// is not in the set. If w is already in the set, no change is made.
			words.add(w);
		}

		return words;
	}

	/** Return the set of words in s. */
	public static HashSet<String> createSet2(String s) {
		// Wow, a one-line method.
		// First, use split to create an array of words in s.
		// Second, use function asList to turn the array into a List
		// Third, create a new HashSet that contains the elements of the List.
		// Since HashSet is a set, duplicate are not included.
		return new HashSet<>(Arrays.asList(s.split(" ")));
	}

	/** Return a map that gives the frequency of each word in s, <br>
	 * i.e. how many times it occurs in s. */
	public static HashMap<String, Integer> findFreq(String s) {
		String[] b= s.split(" ");

		HashMap<String, Integer> map= new HashMap<>();

		// process each element w of array b ---foreach loop
		for (String w : b) {
			// This call returns null if w is not in map and
			// the number of times w occurs if w is in map
			Integer ct= map.get(w);

			if (ct != null) map.put(w, ct + 1);
			else map.put(w, 1);
		}

		return map;
	}
}
