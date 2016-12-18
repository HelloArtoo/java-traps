## Java Traps

things you don't notice.


## Start Demo
```java
package com.artoo.java_traps.demos;

/**
 * 
 * @author artoo
 * 
 */
public class IntegerCache {

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

```

`why 'a==b' is true and 'e==f' is true ?`

## Contents

More than 50 demos.
