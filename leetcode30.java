

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode30 {

  // Main method to find all starting indices where concatenation of all words occurs
  public List<Integer> findSubstring(String s, String[] words) {

    int n = words.length;  // Number of words in the input array

    // Map to store the frequency of each word in the input array
    HashMap<String, Integer> map = new HashMap<>();

    // Result list to store all valid starting indices
    List<Integer> ans = new ArrayList<>();

    // Populate the frequency map for the words array
    for (int i = 0; i < n; i++) {
      map.put(words[i], map.getOrDefault(words[i], 0) + 1);
    }

    // Total length of all words combined (concatenated string size)
    int k = words[0].length() * words.length;

    // Length of each word (assuming all words are same length)
    int z = words[0].length();

    // Two pointers for sliding window
    int i = 0, j = 0;

    // Slide the window through the string `s`
    while (j < s.length()) {

      // Check if the window size is equal to total concatenated word length
      if (j - i + 1 == k) {

        // Get the substring of the same length as all concatenated words
        String sub = s.substring(i, j + 1);

        // Map to store the frequency of words in the current substring
        HashMap<String, Integer> map2 = new HashMap<>();

        int p = 0;

        // Split the substring into word-sized chunks and count frequency
        while (p < sub.length()) {
          String temp = sub.substring(p, p + z); // extract a word
          map2.put(temp, map2.getOrDefault(temp, 0) + 1); // count it
          p += z; // move to the next word
        }

        // Compare the original word frequency map with current substring's map
        if (map.equals(map2)) {
          ans.add(i); // valid index found
        }

        i++; // move window start forward
      }

      j++; // move window end forward
    }

    // Return the list of all valid starting indices
    return ans;
  }

  public static void main(String[] args) {
    String arr[] = {"ab", "cd", "ef"};
    System.out.println(new leetcode30().findSubstring("abcdefab", arr));
  }
}
