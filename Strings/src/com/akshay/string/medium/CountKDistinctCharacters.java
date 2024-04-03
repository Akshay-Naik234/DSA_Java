package com.akshay.string.medium;

public class CountKDistinctCharacters {
	static int countSubstringsWithAtMostKDistinctChars(String s, int k) {
		int left = 0, right = 0, n = s.length(), distinctCount = 0, substringCount = 0;
		int[] charFrequency = new int[26];

		while (right < n) {
			int charIndex = s.charAt(right) - 'a';
			charFrequency[charIndex]++;

			if (charFrequency[charIndex] == 1) {
				distinctCount++;
			}

			while (distinctCount > k) {
				charFrequency[s.charAt(left) - 'a']--;
				if (charFrequency[s.charAt(left) - 'a'] == 0) {
					distinctCount--;
				}
				left++;
			}

			substringCount += (right - left + 1);
			right++;
		}
		return substringCount;
	}

	static int countSubstringsWithExactlyKDistinctChars(String str, int k) {
		int countAtMostK = countSubstringsWithAtMostKDistinctChars(str, k);
		int countAtMostKMinus1 = countSubstringsWithAtMostKDistinctChars(str, k - 1);
		return countAtMostK - countAtMostKMinus1;
	}

	public static void main(String[] args) {
		String inputString = "aacfssa";
		int k = 3;
		int result = countSubstringsWithExactlyKDistinctChars(inputString, k);
		System.out.println("The number of substrings with exactly " + k + " distinct characters is: " + result);
	}
}
