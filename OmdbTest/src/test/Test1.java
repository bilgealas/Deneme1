package test;

import java.awt.print.Printable;

public class Test1 {
	
	String name;
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
	
	public void printWorld(String name){
		this.name = name;
		System.out.println("World is : " + name);
	}
}
