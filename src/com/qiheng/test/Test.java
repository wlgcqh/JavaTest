package com.qiheng.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test { 
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(5);
		list.add(10);

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
	}
}
