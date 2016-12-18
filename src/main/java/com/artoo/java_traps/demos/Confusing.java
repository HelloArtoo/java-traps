package com.artoo.java_traps.demos;

public class Confusing {
	private Confusing(Object o) {
		System.out.println("Object");
	}

	private Confusing(double[] aArr) { // 找最精确的一个
		System.out.println("double array");
	}

	/**
	 * Java 的重载解析过程是以两阶段运行的。第一阶段选取所有可获得并且可应用的方法或构造器。第二阶段在第一阶段选取的方法或构造器中选取最精确的一个。
	 * 如果一个方法或构造器可以接受传递给另一个方法或构造器的任何参数,那么我们就说第一个方法比第二个方法缺乏精确性。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Confusing(null); // double array
		// 正确调用：
		new Confusing((Object) null);

		/**
		 * 总之,重载版本的解析可能会产生混淆。应该尽可能地避免重载,如果你必须进行重载,那么你必须遵守上述方针,以最小化这种混淆。
		 * 如果一个设计糟糕的API 强制你在不同的重载版本之间进行选择,那么请将实际的参数转型为你希望调用的重载版本的形式参数所具有的类型。
		 */

	}

}
