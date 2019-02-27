/** An instance maintains a time of day */
public class time {
	/** hour of the day, in 0..23. */
	private int hr ;
	/** minute of the hour, in 0..59. */
	private int min ;
	/** Return hour of the day */
	public int getHour() {
		return hr ;
	}
	/** Return minute of the hour */
	public int getMinute() {
		return min ;
	}
	/** Change this object’s hour to h.<br>
	 * Precondition: h in 0..23. */
	
	public void sethour(int h) {
		hr = h ;
		
	}
	/** = a representation of this time, e.g. 09:05*/
	@Override
	public String toString() {
		return prepend(hr) + ":" + prepend(min);
	}
	private String prepend(int i) {
		if (i > 9 || i < 0) return "" + i;
		return "0" + i;
	}
	

}
