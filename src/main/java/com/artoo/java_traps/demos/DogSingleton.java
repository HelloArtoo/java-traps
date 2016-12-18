package com.artoo.java_traps.demos;

/**
 * 
 * 下面的程序真的能保证单例吗？ 不能
 */
public class DogSingleton extends Exception {
	public static final DogSingleton INSTANCE = new DogSingleton();

	private DogSingleton() {
	}

	public String toString() {
		return "Woof";
	}

	/**
	 * 这个类可能看起来像一个单件,但它并不是。问题在于,Dog 扩展了 Exception, 而 Exception 实现了
	 * java.io.Serializable。这就意味着 Dog 是可序列化的
	 * (serializable),并且解序列(deserialization)会创建一个隐藏的构造器。 正如下面的这段程序所演示的,如果你序列化了
	 * Dog.INSTANCE,然后对得到的 字节序列(byte sequence)进行解序列,最后你就会得到另外一个 Dog。该程 序打印的是
	 * false,表示新的 Dog 实例和原来的那个实例是不同的,并且它还打 印了 Woof,说明新的 Dog 实例也具有相应的功能
	 * 
	 * 这个谜题的主要教训就是一个实现了 Serializable 的单件类,必须有一个 readResolve
	 * 方法,用以返回它的唯一的实例。一个次要的教训就是,有可能由 于对一个实现了 Serializable 的类进行了扩展,或者由于实现了一个扩展自
	 * Serializable 的接口,使得我们在无意中实现了 Serializable。
	 */

	// 要订正这个问题,可在 Dog 中添加一个 readResolve 方法,它可以将那个隐藏的 构造器转变为一个隐藏的静态工厂(static
	// factory),以返回原来那个的 Dog
	public Object readResolve() {
		return INSTANCE;
	}

}
