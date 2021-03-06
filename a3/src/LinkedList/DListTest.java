package LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DListTest {

	@Test
	public void testprependandtoStringR() {
		DList<Integer> b = new DList<>();
		assertEquals("[]", b.toString());
		assertEquals("[]", b.toStringR());
		assertEquals(0, b.size());

		DList<String> ll = new DList<>();
		assertEquals(0, b.size());
		ll.prepend("Sampson");

		assertEquals("[Sampson]", ll.toString());
		assertEquals("Sampson", ll.last());
		assertEquals(1, ll.size());
		assertEquals("[Sampson]", ll.toStringR());

		ll.prepend("dan");

		assertEquals("[dan, Sampson]", ll.toString());
		assertEquals(2, ll.size());
		assertEquals("[Sampson, dan]", ll.toStringR());

		DList<String> emp = new DList<>();
		emp.prepend("");
		emp.prepend("");
		assertEquals("[, ]", emp.toString());
		assertEquals(2, emp.size());
		assertEquals("[, ]", emp.toStringR());

	}

	@Test
	public void testappend() {
		DList<String> ll = new DList<>();
		ll.prepend("Sampson");
		ll.prepend("dan");
		ll.append("Judi");

		assertEquals("[dan, Sampson, Judi]", ll.toString());
		assertEquals(3, ll.size());
		assertEquals("[Judi, Sampson, dan]", ll.toStringR());

	}

	@Test
	public void testgetnode() {
		DList<String> ll = new DList<>();
		ll.prepend("Sampson");
		DList<String>.Node a = ll.getNode(0);
		assertEquals(null, a.prev());
		assertEquals(null, a.next());
		assertEquals("Sampson", a.value());
		ll.append("dan");
		ll.append("Judi");
		ll.append("hanna");
		ll.append("babe");
		assertEquals(5, ll.size());
		DList<String>.Node b = ll.getNode(1);
		DList<String>.Node c = ll.getNode(2);
		assertEquals(a, b.prev());
		assertEquals(c, b.next());
		assertEquals("dan", b.value());
		assertEquals("Judi", c.value());
		DList<String>.Node d = ll.getNode(3);
		assertEquals("hanna", d.value());

	}

	@Test
	public void testdelete() {
		DList<String> ll = new DList<>();
		ll.prepend("Sampson");
		DList<String>.Node a = ll.getNode(0);
		ll.delete(a);
		assertEquals(0, ll.size());

		ll.append("Sampson");
		ll.append("dan");
		ll.append("Judi");
		ll.append("hanna");

		assertEquals("[Sampson, dan, Judi, hanna]", ll.toString());
		assertEquals(4, ll.size());

		DList<String>.Node b = ll.getNode(1);
		ll.delete(b);
		DList<String>.Node c = ll.getNode(1);
		assertEquals("[Sampson, Judi, hanna]", ll.toString());
		assertEquals("Judi", c.value());
		// check if removing first works
		DList<String>.Node f = ll.getNode(0);
		ll.delete(f);
		assertEquals("[Judi, hanna]", ll.toString());
		DList<String>.Node g = ll.getNode(0);
		assertEquals("Judi", g.value());

		DList<String>.Node h = ll.getNode(1);
		ll.delete(h);
		assertEquals("[Judi]", ll.toString());

	}

	@Test
	public void testinsertbefore() {
		DList<String> ll = new DList<>();
		ll.append("Sampson");
		ll.append("dan");
		ll.append("Judi");
		ll.append("hanna");
		assertEquals(4, ll.size());
		ll.insertBefore("Kigali", ll.getNode(1));
		assertEquals(5, ll.size());
		DList<String>.Node f = ll.getNode(1);
		assertEquals("Kigali", f.value());
		ll.insertBefore("Nairobi", ll.getNode(0));
		assertEquals(6, ll.size());
		DList<String>.Node g = ll.getNode(0);
		assertEquals("Nairobi", g.value());

	}

}
