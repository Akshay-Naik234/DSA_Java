package com.akshay.graph.BFSAndDFS;

import java.util.*;

public class LeetCode_127 {

	static class Pair {
		String first;
		int second;

		Pair(String first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>();
		for (String word : wordList) {
			set.add(word);
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(beginWord, 1));
		set.remove(beginWord);
		while (!q.isEmpty()) {
			String word = q.peek().first;
			int step = q.peek().second;
			q.remove();
			if (word.equals(endWord) == true) {
				return step;
			}
			for (int i = 0; i < word.length(); i++) {
				char[] charArray = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					charArray[i] = c;
					String replacedString = new String(charArray);
					if (set.contains(replacedString)) {
						q.add(new Pair(replacedString, step + 1));
						set.remove(replacedString);
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String startWord = "der", targetWord = "dfs";
		String[] wordList = { "des", "der", "dfr", "dgt", "dfs" };
		List<String> list = Arrays.asList(wordList);
		int res = ladderLength(startWord, targetWord, list);
		System.out.println(res);
	}
}
