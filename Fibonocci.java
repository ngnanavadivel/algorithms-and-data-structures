package com.gnanavad.compilerete.demo;

public class Fibonocci {
	
	public static void printSeries(Integer count) {
		for(int i = 1; i <= count; ++i) {
			System.out.println(_getNthFibonocciNumber(i));
		}
	}
	
	private static Integer _getNthFibonocciNumber(int i) {
		if(i == 1 || i == 2 ) {
			return 1;
		}		
		return _getNthFibonocciNumber(i - 2) + _getNthFibonocciNumber(i - 1);
	}

	public static void main(String[] args) {
		Fibonocci.printSeries(10);
	}
}
