package com.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class AdvancedStringAssignment {
	
	static void charFrequency(String str) {
		HashMap<Character,Integer> hm = new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			
			char ch = str.charAt(i);
			
			if(hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch)+1);
			}
			else {
				hm.put(ch, 1);
			}
			
		}
		
		System.out.println(hm);	
		
	}

	static boolean isPalindrome(String str) {
		
		StringBuilder sb = new StringBuilder(str);
		String rev = sb.reverse().toString();
		
		return rev.equalsIgnoreCase(str);
		
		
	}
	
	static boolean isAnagram(String str1, String str2) {
		
		String s1 = str1.replace(" ", "").toLowerCase();
		String s2 = str2.replace(" ", "").toLowerCase();
		
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		return Arrays.equals(a1, a2);
		
	}
	
	static String longestUniqueSubstring(String str) {
		if (str == null || str.isEmpty()) {
            return "";
        }

        int start = 0, end = 0, maxLength = 0;
        int longestStart = 0;
        HashSet<Character> uniqueChars = new HashSet<>();

        while (end < str.length()) {
            char currentChar = str.charAt(end);
            
            while (uniqueChars.contains(currentChar)) {
                uniqueChars.remove(str.charAt(start));
                start++;
            }
            
            uniqueChars.add(currentChar);
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                longestStart = start;
            }
            end++;
        }

        return str.substring(longestStart, longestStart + maxLength);
	}
	
	static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i)).append(count);
                count = 1;
            }
        }

        String compressedString = compressed.toString();

        return compressedString.length() < str.length() ? compressedString : str;
	}
	
	static void findPermutations(String str, String ans)
    {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
 
        for (int i = 0; i < str.length(); i++) {
 
            char ch = str.charAt(i);
 
            String ros = str.substring(0, i) +
                        str.substring(i + 1);
 
            findPermutations(ros, ans + ch);
        }
    }
	
    static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        Set<Character> seenCharacters = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (!seenCharacters.contains(c)) {
                seenCharacters.add(c);
                result.append(c);
            }
        }

        return result.toString();
    }
	
    static String reverseWords(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        String[] words = str.split("\\s+");

        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
    
	public static void main(String[] args) {
	String str = "AbCDcBa";
//		charFrequency(str);
		
	System.out.println(isPalindrome("str"));
	String str1 = "Learn";
	String str2 = "ear  nl";
	System.out.println(isAnagram(str1, str2));
		System.out.println(longestUniqueSubstring("Saurabh Patil"));
		System.out.println(compressString("aaaabbbccddddd"));
		
	//	findPermutations("aba", "");
		System.out.println(removeDuplicates("abbcadd"));
		
		System.out.println(reverseWords("I am Saurabh Patil"));
		
		
	}

}
