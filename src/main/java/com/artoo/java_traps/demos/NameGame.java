package com.artoo.java_traps.demos;

import java.util.IdentityHashMap;
import java.util.Map;

public class NameGame {

	/**
	 * IdentityHashMap 的文档中叙述道: “这个类用一个散列表实现了 Map 接口,它在比较键时,使用的是引用等价性而
	 * 不是值等价性”之所以为1，是因为字符常量引起的（字符常量是内存限定的，相等的字符串常量同时也是相同的）
	 * 
	 * 不要使用 IdentityHashMap,除非你需要其基于标识 的语义;它不是一个通用目的的 Map 实现。这些语义对于实现保持拓扑结构的对
	 * 象图转换(topology-preserving object graph transformations)非常有用,
	 * 例如序列化和深层复制。我们得到的次要教训是字符串常量是内存限定的。在任何时候,程序都应该尽量不依赖于这种行为去保证它们 的操作正确。
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> m = new IdentityHashMap<String, String>();
		m.put("Mickey", "Mouce");
		m.put("Mickey", "Mantle");
		System.out.println(m.size());

	}

}
