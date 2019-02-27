/** An instance maintains the length and width of a rectangle. */
public class Rectangle {
	/**
	 * If this rectangle is square, length is its length and width and width is
	 * null.
	 */
	private Double length;
	/**
	 * If this rectangle is not square, length is its length and width is its width.
	 */
	private Double width;

	/**
	 * Constructor: a rectangle with length l and width w. Throw an exception l or w
	 * if negative.
	 */
	public Rectangle(double l, double w) {
		try {
			if (l < 0 || w < 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Negative value entered! ");
		}
		// assert l > 0 && w > 0;
		length = Math.abs(l);

		width = Math.abs(w);
	}

	/**
	 * Constructor: a l x l square. Throw an exception if l negative.
	 */
	public Rectangle(double l) {
		try {
			if (l < 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Negative value of l entered! ");
		}
		length = Math.abs(l);
	}

	/** = the length of the rectangle */
	public double getLength() {
		return length;
	}

	/** = the width of the rectangle */
	public double getWidth() {
		if (width == null) {
			return length;
		}
		return width;
	}

	/** Set the length of the rectangle to length */
	public void setLength(double length) {
		this.length = length;
	}

	/** Set the width of the rectangle to width */
	public void setWidth(double k) {
		if (width == null) {
			width = length;
		}
		width = k;
	}

	/** = the area of the rectangle */
	public Double getArea() {
		/**
		 * if (width == null) { return length * length; }
		 */
		if (!length.equals(width)) {
			return length * width;
		}
		return null;
	}

	/** = the perimeter of the rectangle */
	public Double getPerimeter() {
		if (width != null) {
			return 2 * (length + width);
		}
		return 4 * length;
	}
}
