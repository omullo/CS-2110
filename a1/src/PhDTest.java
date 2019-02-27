import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PhDTest {

	@Test
	void testGroupA() {
		PhD PhD1 = new PhD(11, 1879, "Charles Babbage");
		assertThrows(AssertionError.class, () -> {
			new PhD(11, 1879, null);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD(11, 1879, "");
		});
		assertThrows(AssertionError.class, () -> {
			new PhD(0, 1879, "Babbage");
		});
		assertThrows(AssertionError.class, () -> {
			new PhD(14, 1879, "Babbage");
		});
		assertEquals("Charles Babbage", PhD1.name());
		assertEquals(11, PhD1.month());
		assertEquals(1879, PhD1.year());
		assertEquals(null, PhD1.first_advisor());
		assertEquals(null, PhD1.second_advisor());
		assertEquals(0, PhD1.num_adv());
	}

	@Test
	void testGroupB() {
		PhD PhD2 = new PhD(10, 1997, "Dorsilla Akinyi");
		PhD Omullo = new PhD(12, 2027, "Omullo");
		PhD Samantha = new PhD(05, 2031, "Samantha");

		assertThrows(AssertionError.class, () -> {
			PhD Akinyi = new PhD(9, 1967, "Akinyi", Omullo);
			Akinyi.setAdvisor1(Samantha);
		});

		assertThrows(AssertionError.class, () -> {
			PhD Trevor = new PhD(9, 1967, "Trevor", null);
			Trevor.setAdvisor1(Samantha);
		});

		PhD2.setAdvisor1(Omullo);
		assertEquals(Omullo, PhD2.first_advisor());

		PhD2.setAdvisor2(Samantha);
		assertEquals(Samantha, PhD2.second_advisor());

		assertThrows(AssertionError.class, () -> {
			PhD Anthony = new PhD(05, 1989, "Anthony", null);
			Anthony.setAdvisor1(Samantha);
		});

		assertThrows(AssertionError.class, () -> {
			PhD Kenyatta = new PhD(05, 1994, "Kenyatta", Omullo);
			Kenyatta.setAdvisor1(null);
		});

		assertThrows(AssertionError.class, () -> {
			PhD Parissa = new PhD(05, 1994, "Parissa", Omullo, PhD2);
			Parissa.setAdvisor1(Samantha);
		});

		assertEquals(4, Omullo.num_adv());
		assertEquals(1, Samantha.num_adv());

	}

	@Test
	void testGroupC() {

		PhD Marylyn = new PhD(01, 1951, " Marylyn Monroe ");
		PhD Norma = new PhD(06, 1957, " Norma Jean ", Marylyn);

		assertThrows(AssertionError.class, () -> {
			new PhD(11, 1879, null);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD(11, 1879, "");
		});
		assertThrows(AssertionError.class, () -> {
			new PhD(0, 1879, "Babbage");
		});
		assertThrows(AssertionError.class, () -> {
			new PhD(14, 1879, "Babbage");
		});
		assertThrows(AssertionError.class, () -> {
			new PhD(14, 1879, "Babbage", null);
		});

		assertEquals(" Norma Jean ", Norma.name());
		assertEquals(06, Norma.month());
		assertEquals(1957, Norma.year());
		assertEquals(Marylyn, Norma.first_advisor());
		assertEquals(null, Norma.second_advisor());
		assertEquals(1, Marylyn.num_adv());

		PhD Mozart = new PhD(11, 1988, " Wolfgang Amadeus Mozart ");
		PhD Jean = new PhD(06, 1957, " Norma Jean ", Marylyn, Mozart);

		assertThrows(AssertionError.class, () -> {
			new PhD(14, 1879, "Babbage", Mozart, null);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD(14, 1879, "Babbage", Mozart, Mozart);
		});
		assertEquals(Marylyn, Jean.first_advisor());
		assertEquals(Mozart, Jean.second_advisor());
		assertEquals(2, Marylyn.num_adv());
		assertEquals(1, Mozart.num_adv());

	}

	@Test
	void testgroupD() {

		PhD Aug_1790 = new PhD(8, 1790, " Ludwig Beethoven ");
		PhD Jun_1810 = new PhD(06, 1810, " Sebastian Bach ");
		PhD May_1885 = new PhD(05, 1885, " Ada Lovelace ");
		PhD Dec_1997 = new PhD(12, 1997, " Tina Turner ", Aug_1790, Jun_1810);
		PhD Alyssa = new PhD(06, 1998, " Alyssa Apsel ", Aug_1790, May_1885);
		PhD Daisy = new PhD(9, 2001, "Daisy K Y Fan ", Jun_1810);

		assertEquals(true, Alyssa.gotAfter(Dec_1997));
		assertEquals(false, May_1885.gotAfter(May_1885));

		assertThrows(AssertionError.class, () -> {
			PhD Antonio = new PhD(9, 1967, "Antonio Vivaldi", null);
			Antonio.areSiblings(Dec_1997);
		});

		assertEquals(true, Alyssa.areSiblings(Dec_1997));
		assertEquals(true, Dec_1997.areSiblings(Daisy));
		assertEquals(false, Alyssa.areSiblings(Daisy));
		assertEquals(false, Alyssa.areSiblings(Alyssa));
		assertEquals(false, Alyssa.areSiblings(null));

	}

}
