package com.book.test;

import static org.junit.Assert.*;

import java.util.List;

import com.book.util.JdbcUtil;

public class Test {

	@org.junit.Test
	public void test() {
		String[] str=new String[4];
		str[3]="wushu";
		for (String string : str) {
			System.out.println(string);
		}
	}

}
