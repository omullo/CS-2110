/** NetId: foo6. Time spent:10 */
/** An instance maintains info about the PhD of a person */
public class PhD {
	/** month of PhD award ,In range 1..12 with 1 being January */
	private int month;
	/** Year awarded */
	private int year;
	/** Name of PhD holder, a String of length > 0 */
	private String name;
	/** Name of holder's first advisor null if unknown */
	private PhD first_advisor;
	/** Name of holder's first second null if unknown */
	private PhD second_advisor;
	/** number of advisees */
	private int num_adv;

	/**
	 * Constructor: a PhD with PhD month m, PhD year y, and name n.<br>
	 * The advisors are unknown, and there are 0 advisees.<br>
	 * Precondition: n has at least 1 char and m is in 1..12.
	 */
	public PhD(int m, int y, String n) {
		assert n != null && n.length() >= 1;
		assert m >= 1 && m <= 12;
		name = n;
		month = m;
		year = y;
		first_advisor = null;
		second_advisor = null;
		num_adv = 0;

	}

	/** Return the name of this person. */
	public String name() {
		return name;

	}

	/** Return the month this person got their PhD. */
	public int month() {
		return month;

	}

	/** Return the year this person got their PhD */
	public int year() {
		return year;

	}

	/** Return the first advisor of this PhD (null if unknown). */
	public PhD first_advisor() {
		return first_advisor;

	}

	/**
	 * Return the second advisor of this PhD (null if unknown or <br>
	 * non-existent)
	 */
	public PhD second_advisor() {
		return second_advisor;

	}

	/** Return the number of PhD advisees of this person. */
	public int num_adv() {
		return num_adv;

	}

	/**
	 * Make p the first advisor of this person.<br>
	 * Precondition: the first advisor is unknown and p is not null.
	 */
	public void setAdvisor1(PhD p) {
		assert first_advisor == null && p != null;
		first_advisor = p;
		p.num_adv = p.num_adv + 1;

	}

	/**
	 * Make p the second advisor of this PhD. <br>
	 * Precondition: The first advisor is known, the second advisor is unknown, <br>
	 * p is not null, and p is different from the first advisor.
	 */
	public void setAdvisor2(PhD p) {
		assert first_advisor != null && p != null;
		assert second_advisor == null;
		assert first_advisor != p;
		second_advisor = p;
		p.num_adv = p.num_adv + 1;

	}

	/**
	 * Constructor: a PhD with PhD month m, PhD year y, name n, <br>
	 * first advisor adv1, and no second advisor.<br>
	 * Precondition: n has at least 1 char, m is in 1..12, and adv1 is not null.
	 */
	public PhD(int m, int y, String n, PhD adv1) {
		assert n != null && n.length() >= 1;
		assert m >= 1 && m <= 12;
		assert adv1 != null;
		month = m;
		year = y;
		name = n;
		first_advisor = adv1;
		second_advisor = null;
		num_adv = 0;
		adv1.num_adv = adv1.num_adv + 1;

	}

	/**
	 * Constructor: a PhD with PhD month m, PhD year y, name n, <br>
	 * first advisor adv1, and second advisor adv2.<br>
	 * Precondition: n has at least 1 char, m is in 1..12,<br>
	 * adv1 and adv2 are not null, and adv1 and adv2 are different.
	 */
	public PhD(int m, int y, String n, PhD adv1, PhD adv2) {
		assert n != null && n.length() >= 1;
		assert m >= 1 && m <= 12;
		assert adv2 != null && adv1 != null;
		assert adv1 != adv2;
		month = m;
		year = y;
		name = n;
		first_advisor = adv1;
		second_advisor = adv2;
		num_adv = 0;
		adv1.num_adv = adv1.num_adv + 1;
		adv2.num_adv = adv2.num_adv + 1;

	}

	/**
	 * Return value of: this PhD got the PhD after p.<br>
	 * Precondition: p is not null.
	 */

	public boolean gotAfter(PhD p) {

		/** I opted to convert the given times in months for easy comparison */
		/**
		 * int p_time = p.year() * 12 + p.month(); int this_time = year() * 12 +
		 * month(); boolean check = p != null && this_time > p_time;
		 */
		assert p != null;
		return year >= p.year && month > p.month || p.month >= month && year > p.year;
		// return check;

	}

	/**
	 * Return value of: p is not null and this PhD and p are intellectual siblings.
	 */

	public boolean areSiblings(PhD p) {
		// assert( p != null ) ;
		boolean check = p != null && this != p
				&& (first_advisor == p.first_advisor && p.first_advisor != null
						|| second_advisor == p.second_advisor && p.second_advisor != null
						|| first_advisor == p.second_advisor && p.second_advisor != null
						|| second_advisor == p.first_advisor && p.first_advisor != null);

		return check;

	}

}
