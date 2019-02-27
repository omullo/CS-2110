//package LinkedList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import org.junit.jupiter.api.Test;
//
//class DListTest {
//	@Test
//	public void testConstructor() {
//		DList<Integer> b = new DList<Integere>();
//		assertEquals("[]", b.toString());
//		assertEquals("[]", b.toStringR());
//		assertEquals(0, b.size());
//	}
//
//	@Test
//	public void testPrepend() {
//		DList<String> l = new DList<>();
//		l.prepend("Sampson");
//		assertEquals("[Sampson]", l.toString());
//		assertEquals("[Sampson]", l.toStringR());
//		assertEquals(1, l.size());
//
//		l.prepend("EquityBank");
//		assertEquals("Sampson", l.last());
//		assertEquals("EquityBank", l.first());
//		assertEquals("[EquityBank, Sampson]", l.toString());
//		assertEquals("[Sampson, EquityBank]", l.toStringR());
//		assertEquals(2, l.size());
//
//	}
//
//	@Test
//	public void testAppend() {
//		DList<String> m = new DList<>();
////		m.append("Sampson");
////		assertEquals("[Sampson]", m.toString());
////		assertEquals("[Sampson]", m.toStringR());
////		assertEquals(1, m.size());
////
////		m.append("EquityBank");
//
//		m.prepend("Sampson");
//		m.prepend("Dan");
//		m.append("Judi");
//		assertEquals("[Sampson, Dan, Judi]", m.toString());
//		assertEquals(3, m.size());
//		// assertEquals("EquityBank", m.last());
//
//	}
//
//	@Test
//	public void testGetNode() {
//		DList<String> n = new DList<>();
//		n.append("Mumbai");
//		n.prepend("Nairobi");
//		n.append("Washington");
//		n.prepend("Accra");
//		n.append("Cranckfergus");
//		assertEquals(5, n.size());
//		assertEquals("Accra", n.getNode(0).value());
//		assertEquals("Nairobi", n.getNode(1).value());
//		assertEquals("Mumbai", n.getNode(2).value());
//		assertEquals("Washington", n.getNode(3).value());
//
//		assertThrows(AssertionError.class, () -> {
//			n.getNode(-5);
//		});
//	}
//
//	@Test
//	public void testDeleteNode() {
//		DList<String> b = new DList<>();
////		b.append("Mumbai");
////		b.delete(b.getNode(0));
////		assertEquals(0, b.size());
//
//		b.append("Mumbai");
//		b.prepend("Nairobi");
//		b.append("Washington");
//		b.prepend("Accra");
//		b.append("Cranckfergus");
//		assertEquals(5, b.size());
//		assertEquals("Mumbai", b.getNode(2).value());
//
//		b.delete(b.getNode(2));
//		assertEquals(4, b.size());
//
//	}
//
//	@Test
//	public void TestinsertAfter() {
//		DList<String> c = new DList<>();
//		c.append("Mumbai");
//		c.prepend("Nairobi");
//		c.append("Washington");
//		c.prepend("Accra");
//		c.append("Cranckfergus");
//		assertEquals(5, c.size());
//
//		c.insertBefore("Kigali", c.getNode(1));
//		assertEquals(6, c.size());
//		c.insertBefore("Nairobi", c.getNode(0));
//		assertEquals(6, c.size());
//
//	}
//
//}
//
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

		// DList<String>.Node f= ll.getNode(0);
		// ll.delete(f);
		// assertEquals(null, f.value());
		ll.append("Sampson");
		ll.append("dan");
		ll.append("Judi");
		ll.append("hanna");
		// get node, delete that node and check if size is down and if it gets new nodes
		// corresponding to the
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
