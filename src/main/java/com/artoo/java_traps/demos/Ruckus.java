package com.artoo.java_traps.demos;

public class Ruckus {

	/**
	 * Dog 和 Cat 都从其共同的超类那里继承了 count 域, count 又是一个静态
	 * 而域。每一个静态域在声明它的类及其所有子类中共享一份单一的拷贝,因此 Dog和 Cat 使用的是相同的 count 域。每一个对 woof 或
	 * meow 的调用都在递增这个域, 该程序分别通过调用 Dog.getCount 和 Cat.getCount 读取因此它被递增了 5 次。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dogs[] = { new Dog(), new Dog() };
		for (int i = 0; i < dogs.length; i++)
			dogs[i].woof();
		Cat cats[] = { new Cat(), new Cat(), new Cat() };
		for (int i = 0; i < cats.length; i++)
			cats[i].meow();

		System.out.print(Dog.getCount() + " woofs and ");
		System.out.println(Cat.getCount() + " meows");
		// print: 5 woofs and 5 meows

		// 正确的因该是猫狗都维护自己的count，参考CatYes,DogYes

		/**
		 * 总之,静态域由声明它的类及其所有子类所共享。如果你需要让每一个子类都具有某个域的单独拷贝,那么你必须在每一个子类中声明一个单独的静态域。
		 * 如果每一个实例都需要一个单独的拷贝
		 * ,那么你可以在基类中声明一个非静态域。还有就是,要优选组合而不是继承,除非导出类真的需要被当作是某一种基类来看待。
		 */

	}

}

class Counter {
	private static int count = 0;

	public static final synchronized void increment() {
		count++;
	}

	public static final synchronized int getCount() {
		return count;
	}
}

class Dog extends Counter {
	public Dog() {
	}

	public void woof() {
		increment();
	}
}

class Cat extends Counter {
	public Cat() {
	}

	public void meow() {
		increment();
	}
}

// 正确方式
class DogYes extends Counter {
	private static int woofCounter;

	public DogYes() {
	}

	public static int woofCount() {
		return woofCounter;
	}

	public void woof() {
		woofCounter++;
	};

}

class CatYes extends Counter {
	private static int meowCounter;

	public CatYes() {
	}

	public static int meowCount() {
		return meowCounter;
	}

	public void meow() {
		meowCounter++;
	};

}