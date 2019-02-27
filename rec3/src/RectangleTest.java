import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RectangleTest {

	@Test
	void testConstructor1() {
		Rectangle Socrates = new Rectangle(6, 4);
		assertEquals(6, Socrates.getLength());
		assertEquals(4, Socrates.getWidth());

		Rectangle B = new Rectangle(-5, -6);
		assertEquals(5, B.getLength());
		assertEquals(6, B.getWidth());

		Rectangle C = new Rectangle(0, 0);
		assertEquals(0, C.getLength());
		assertEquals(0, C.getWidth());

		/**
		 * assertThrows(AssertionError.class, () -> { new Rectangle(-1.0, 12.4); });
		 */
	}

	@Test

	void testConctructor2() {
		Rectangle D = new Rectangle(2.5);
		assertEquals(2.5, D.getLength());
		assertEquals(2.5, D.getWidth());

		Rectangle E = new Rectangle(-6);
		assertEquals(6, E.getLength());
		assertEquals(6, E.getWidth());
	}

	@Test

	public void testSetters() {
		Rectangle t = new Rectangle(2.0, 4.0);
		Rectangle m = new Rectangle(6.2);
		m.setWidth(8.2);
		t.setLength(5.0);
		assertEquals(5.0, t.getLength());
		t.setWidth(3.2);
		assertEquals(3.2, t.getWidth());
		assertEquals(8.2, m.getWidth());

		Rectangle E = new Rectangle(7, 9);
		E.setLength(1);
		assertEquals(1, E.getLength());
		E.setLength(-1);
		assertEquals(-1, E.getLength());
		E.setLength(0);
		assertEquals(0, E.getLength());
		E.setLength(9);
		assertEquals(9, E.getLength());

		E.setWidth(1);
		assertEquals(1, E.getWidth());
		E.setWidth(-1);
		assertEquals(-1, E.getWidth());
		E.setWidth(0);
		assertEquals(0, E.getWidth());
		E.setWidth(7);
		assertEquals(7, E.getWidth());

	}

	@Test

	public void testArea() {
		Rectangle F1 = new Rectangle(8, 7);
		assertEquals((Double) (double) 56, F1.getArea());

		Rectangle F2 = new Rectangle(8, 8);
		assertEquals(null, F2.getArea());

		Rectangle t = new Rectangle(2.0, 4.0);
		Rectangle k = new Rectangle(2.0);
		assertEquals(8.0, (double) t.getArea());
		assertEquals(new Double(4.0), k.getArea());

	}

	@Test
	void testGetPerimeter() {
		Rectangle t = new Rectangle(2.0, 4.0);
		Rectangle k = new Rectangle(2.0);
		assertEquals(new Double(12.0), t.getPerimeter());
		assertEquals(new Double(8.0), k.getPerimeter());
		Rectangle I = new Rectangle(8, 0);
		assertEquals((Double) (double) 0, I.getPerimeter());

		Rectangle G = new Rectangle(8, 7);
		assertEquals((Double) (double) 30, G.getPerimeter());

	}

}
