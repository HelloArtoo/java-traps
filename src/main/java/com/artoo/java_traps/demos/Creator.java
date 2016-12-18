package com.artoo.java_traps.demos;

public class Creator {

	/**
	 * 总之,一个本地变量声明不能被用作 for、while 或 do 循环中的重复执行语句,
	 * 它作为一条语句只能出现在一个语句块中。另外,在使用一个变量来对实例的创建进行计数时,要使用 long 类型而不是 int
	 * 类型的变量,以防止溢出。最后, 如果你打算在多线程中创建实例,要么将对实例计数器的访问进行同步,要么使用一个 AtomicLong 类型的计数器
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Exception in thread "main" java.lang.Error: Unresolved compilation
		 * problems: Syntax error, insert "AssignmentOperator Expression" to
		 * complete Assignment Syntax error, insert ";" to complete Statement
		 * Creature cannot be resolved to a variable creature cannot be resolved
		 * to a variable
		 * 
		 * Java 语言规范不允许一个本地变量声明语句作为一条语句在 for、while 或
		 * do循环中重复执行。一个本地变量声明作为一条语句只能直接出现在一个语句块中。
		 * (一个语句块是由一对花括号以及包含在这对花括展中的语句和声明构成的。)
		 */
		/*
		 * for(int i=0;i<100;i++) Creature creature = new Creature();
		 */
		for (int i = 0; i < 100; i++) {
			Creature creature = new Creature();
		} // 必须打大括号
		System.out.println(Creature.numCreated());

	}

}

class Creature {
	private static long numCreated = 0;

	public Creature() {
		numCreated++;
	}

	public static long numCreated() {
		return numCreated;
	}
}