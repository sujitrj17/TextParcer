package com.driven4.Parser;

import java.util.Arrays;
import java.util.List;

public class A {

	public static void main(String[] args) {
		String a = "love";
		String b = "you";
		System.out.println(a+" "+b);
		a = a+b;//loveyou
		b = a.substring(0,a.length()-b.length());
		a = a.substring(b.length());
System.out.println(a+" "+b);

List<String> l = Arrays.asList("a","b","c","d");
System.out.println(l);
List<String> m = Arrays.asList("a","b","g","h");
System.out.println(m);

l.retainAll(m);
System.out.println(m);
	}
}
