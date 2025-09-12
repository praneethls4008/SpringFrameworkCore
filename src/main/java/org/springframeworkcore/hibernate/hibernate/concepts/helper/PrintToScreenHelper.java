package org.springframeworkcore.hibernate.hibernate.concepts.helper;

public class PrintToScreenHelper {
	public static void print(String msg) {
		int len = msg.length()+10;
		System.out.println("\n\n");
		System.out.println("_".repeat(len));
		System.out.print("\t");
		System.out.println(msg);
		System.out.println("_".repeat(len));
	}
}
