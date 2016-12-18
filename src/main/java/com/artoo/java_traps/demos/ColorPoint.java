package com.artoo.java_traps.demos;

class Point {
	protected final int x, y;
	private final String name;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		name = makeName(); // 3、调用子类的makeName to 4
	}

	protected String makeName() {
		return "[" + x + "," + y + "]";
	}

	public final String toString() {
		return name;
	}
}

/**
 * 改造下：
 * 
 * <pre>
 * class Point {
 * 	protected final int x, y;
 * 	private final String name;
 * 
 * 	Point(int x, int y) {
 * 		this.x = x;
 * 		this.y = y;
 * 	}
 * 
 * 	protected String makeName() {
 * 		return "[" + x + "," + y + "]";
 * 	}
 * 
 * 	public final synchronized String toString() {
 * 		if (name == null)
 * 			makeName();
 * 		return name;
 * 	}
 * </pre>
 * 
 * }
 **/

public class ColorPoint extends Point {
	private final String color;

	ColorPoint(int x, int y, String color) {
		super(x, y); // 2、链接到父类构造器 to 3
		this.color = color; // 5、这时候才初始化，初始化color，但为时已晚。
	}

	protected String makeName() {
		// 4、在子类构造体执行之前调用了。 to 5
		return super.makeName() + ":" + color;
	}

	/**
	 * 首先,程序通过调用 ColorPoint 构造器创建了一个 ColorPoint
	 * 实例(1)。这个构造器以链接调用其超类构造器开始,就像所有构造器所做的那样(2)。超类构造器在构造过程中对该对象的 x 域赋值为 4,对 y
	 * 域赋值为 2。然后该超类构造器调用 makeName,该方法被子类覆写了(3)。ColorPoint 中的 makeName 方法(4)是在
	 * ColorPoint 构造器的程序体之前执行的,这就是问题的核心所在。makeName 方法首先调用
	 * super.makeName,它将返回我们所期望的[4,2],然后该方法在此基础上追加字符串“:”和由 color 域但是此刻 color
	 * 域的值是什么呢?由于它仍处于待初始的值所转换成的字符串。化状态,所以它的值仍旧是缺省值 null。因此,makeName 方法返回的是字符串
	 * “[4,2]:null”。超类构造器将这个值赋给 name 域(3),然后将控制流返回给子类的构造器。这之后子类构造器才将“purple”赋予
	 * color 域(5),但是此刻已经为时过晚了。color 域已经在超类中被用来初始化 name
	 * 域了,并且产生了不正确的值。之后,子类构造器返回,新创建的 ColorPoint 实例被传递给 println 方法,它 适时地调用了该实例的
	 * toString 方法, 这个方法返回的是该实例的 name 域的内容,即“[4,2]:null”,这也就成为了程序要打印的东西
	 * 
	 * 
	 * 总之,在任何情况下,你都务必要记住:不要在构造器中调用可覆 写的方法。在实例初始化中产生的循环将是致命的。该问题的解决方案就是惰性初始化
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 1、首先调用子类构造器 to 2
		System.out.println(new ColorPoint(4, 2, "BLACK")); // [4,2]:null

	}

}
