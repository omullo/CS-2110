import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class Rec4Test {

	@Test
	void testCreateList1() {

		ArrayList<String> list= Rec4
			.createList1("Hartmanis Hopcroft Constable Hartmanis Hartmanis Constable");

		// duplicates are allowed
		assertEquals(6, list.size());
		assertEquals("Hartmanis", list.get(0));
		assertEquals(true, list.contains("Constable"));

		String v= "[Hartmanis, Hopcroft, Constable, Hartmanis, Hartmanis, Constable]";
		assertEquals(v, list.toString());

		list.add("Salton");

		assertEquals(7, list.size());
		assertEquals("Hopcroft", list.get(1));

		// note how the ArrayList shifts the indices on deletion by index
		list.remove(0);
		assertEquals("Hopcroft", list.get(0));
		assertEquals(6, list.size());

		// Put in a second "Hopcroft"
		list.add("Hopcroft");
		assertEquals(7, list.size());

		// by object (which in this case is a String)
		list.remove("Hopcroft");  // remove FIRST occurrence of "Hopcroft"
		assertEquals("Constable", list.get(0));
		assertEquals(true, list.contains("Hopcroft"));
		assertEquals(6, list.size());

	}

	@Test
	void testCreateList2() {
		String s= "many a man of many a letter " +
			"	      has left this World a little better " +
			"	   Alas, it is the poet's curse " +
			"	      to leave this World a little verse " +
			"	   Piet Hein";

		ArrayList<String> list= Rec4.createList1(s);

		// duplicates are allowed
		assertEquals(29, list.size());
		assertEquals("many", list.get(0));
		assertEquals("a", list.get(1));
		assertEquals("man", list.get(2));
		assertEquals(true, list.contains("leave"));
		assertEquals(false, list.contains("leaves"));

		String sss= "[many, a, man, of, many, a, letter, " +
			"has, left, this, World, a, little, better, " +
			"Alas,, it, is, the, poet's, curse, " +
			"to, leave, this, World, a, little, verse, " +
			"Piet, Hein]";

		assertEquals(sss, list.toString());

		// note how the ArrayList shifts the indices on deletion by index
		list.remove(0);
		assertEquals("a", list.get(0));
		assertEquals("man", list.get(1));

		// removal by object (which in this case is a String)
		assertEquals(true, list.contains("World"));
		list.remove("World");  // remove one instance of "World"
		assertEquals(true, list.contains("World"));
		list.remove("World");  // remove one instance of "World"
		assertEquals(false, list.contains("World"));

	}

	@Test
	void testCreateSet1() {
		HashSet<String> set= Rec4.createSet1("the the the the pink pink panther");

		// duplicates are NOT allowed
		assertEquals(3, set.size());
		assertEquals(false, set.isEmpty());
		assertEquals(true, set.contains("the"));
		assertEquals(true, set.contains("pink"));
		assertEquals(true, set.contains("panther"));

		set.add("2110");

		assertEquals(4, set.size());

		// since set is unordered, can remove by element, not by index
		set.remove("2110");
		assertEquals(3, set.size());
	}

	@Test
	void testCreateSet2() {
		HashSet<String> set= Rec4.createSet2(
			"the the the the pink pink panther");

		// duplicates are NOT allowed
		assertEquals(3, set.size());
		assertEquals(false, set.isEmpty());
		assertEquals(true, set.contains("the"));
		assertEquals(true, set.contains("pink"));
		assertEquals(true, set.contains("panther"));
		assertEquals(false, set.contains("Panther"));

		set.add("2110");

		assertEquals(4, set.size());

		// Can remove an element,
		// but since a set has no ordering, can't remove by index
		set.remove("2110");
		assertEquals(3, set.size());
	}

	@Test
	void testCreateMap() {
		HashMap<String, Integer> map= Rec4.findFreq(
			"live as if you were to die tomorrow     " +
				"learn as if you were to live forever" +
				" Mahatma Gandhi");

		assertEquals(13, map.size());
		assertEquals(false, map.isEmpty());
		assertEquals(true, map.containsKey("live"));
		assertEquals(true, map.containsValue(1));

		// Two occurrences of "if"
		assertEquals(2, (int) map.get("if"));

		// One occurrence of "Mahatma"
		assertEquals(1, (int) map.get("Mahatma"));

		// change freq of "if"
		map.put("if", 3);
		assertEquals(3, (int) map.get("if"));

		map.remove("if"); // this removes ALL occurrences of "if"
		assertEquals(null, map.get("if"));

	}

}
