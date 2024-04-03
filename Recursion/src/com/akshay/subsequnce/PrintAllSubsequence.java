package com.akshay.subsequnce;

import java.util.*;

public class PrintAllSubsequence {
	public static List<String> generateSubsequences(String s) {
		List<String> res = new ArrayList<>();
		generateAllSubSequence(0, s, "", res);
		return res;
	}

	private static void generateAllSubSequence(int ind, String s, String temp, List<String> res) {
		if (ind == s.length()) {
			res.add(temp);
			return;
		}
		generateAllSubSequence(ind + 1, s, temp + s.charAt(ind), res);
		generateAllSubSequence(ind + 1, s, temp, res);
	}
	
	public static void main(String[] args) {
		List<String> res = generateSubsequences("abc");
		System.out.println(res);
	}
}
