package com.artoo.java_traps.demos;

/**
 * 
 * @author artoo
 * 
 */
public class IntegerCache {

	/**
	 * <pre>
	 * 对于范围在-128到127的整数，虚拟机做了特殊处理。采用IntegerCache.cache[i + offset]这个方法。从名字，我们可以猜出这是某种缓存机制。
	 * Java对基本数据类型和包装类互转中 使用了缓冲机制。此时的 i=IntegerCache.cache[i + 128] = IntegerCache.cache[228]，
	 * 同样j = IntegerCache.cache[j + 128] = IntgerCache.cache[228]
	 * 因此 Integer引用i中存储的是cache数组第228号元素的地址。同理j也是同一个cache数组的第228号元素的地址(因为cache是Integer的static数组，只有一个)。
	 * i==j比较的是引用地址，因此返回true。
	 * 而 k=new Integer(255);  同样m=new Integer(255) 。
	 * 两次都在堆中开辟了Integer的对象。k和 m 中存储的堆的对象地址是完全不同的。k==m 自然返回false。
	 * 八种基本数据类型和其包装类中 Integer valueOf(int i)、Byte valueOf(byte b)、Short valueOf(short s)、Long valueOf(long l)、
	 * Character valueOf(char c)都是用到了缓冲机制，并且缓冲的范围都是-128~127
	 * 但是，对于包装类Float,Double,Boolean 并没有提供相应的缓冲机制
	 * 
	 * 
	 * 引入缓存机制的作用何在？
	 * 
	 * 假如我们在编程时大量需要值为100（100的范围在-128到127之间）的Integer对象。如果只能通过new来创建，需要在堆中开辟大量值一样的Integer对象。
	 * 这是相当不划算的，IntegerCache.cache很好的起到了缓存的作用。当我们需要Integer i  = 100的时候，直接从cache中取出第[100+128]号元素的地址赋值给引用i，
	 * 再次需要Integer j = 100时，还是直接去这个地址赋值给j。是不是省去了在堆中不停的创建对象的代价了(空间，时间上的消耗都很大)。 
	 * 基本数据的封装类型都提供了valueOf方法，该方法也使用了该缓存机制。正如JDK API文档对valueOf(int i)方法的描述，该方法有可能通过缓存经常请求的值而显著提高空间和时间性能。
	 * 
	 * 
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Integer a = 100; // Method java/lang/Integer.valueOf:
		Integer b = 100;
		Integer c = 255;
		Integer d = 255;
		System.out.println(a == b); // true
		System.out.println(c == d); // false

		Long e = 100L;
		Long f = 100L;
		Long g = 255L;
		Long h = 255L;
		System.out.println(e == f); // true
		System.out.println(g == h); // false

	}

}
