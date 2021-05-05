package com;

import java.util.*;

public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		String sum = "10000.00";
		
        int length = sum.length();
		sum = sum.replaceAll(",", "");
		if (sum.startsWith("0")) System.out.println(sum.substring(0, length - 3) + "=");
		if (sum.endsWith(".00")) System.out.println(sum.substring(0, length - 3) + "=");
		if (sum.endsWith(".00")) System.out.println(sum.replace(".00","="));
        System.out.println(sum.replace('.', '-'));


		

		List<String> params = new ArrayList<>();

		params.add("d");
		params.add("s");	

		for (int index = 0; index < params.size(); index++) {
			System.out.println("index " + index + " " + params.get(index));
			//profileSQL.setString(index, params.get(index));
		}
	}
	
}