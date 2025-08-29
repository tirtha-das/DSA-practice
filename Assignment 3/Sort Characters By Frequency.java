import java.util.*;

class Pair {
    public int cnt;
    public char val;

    public Pair(int cnt, char val) {
        this.cnt = cnt;
        this.val = val;
    }
}

public class FrequencySorter {

    public static String sortByFrequency(String s) {
        int[] freqS = new int[26]; // lowercase
        int[] freqC = new int[26]; // uppercase
        int[] freqD = new int[10];

        Arrays.fill(freqS, 0);
        Arrays.fill(freqC, 0);
        Arrays.fill(freqD, 0);

        // Count frequency
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                freqS[ch - 'a']++;
            } else if (ch >= 'A' && ch <= 'Z') {
                freqC[ch - 'A']++;
            }else{
                freqD[ch - '0']++;
            }
        }

        // Collect into list of pairs
        List<Pair> freq = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freqS[i] > 0) {
                char ch = (char) ('a' + i);
                freq.add(new Pair(freqS[i], ch));
            }
            if (freqC[i] > 0) {
                char ch = (char) ('A' + i);
                freq.add(new Pair(freqC[i], ch));
            }
        }
    for (int i = 0; i < 10; i++) {
            if (freqD[i] > 0) {
                char ch = (char) ('0' + i);
                freq.add(new Pair(freqD[i], ch));
            }
    }
        // Sort in descending order of frequency
        Comparator<Pair> comp = (p1, p2) -> Integer.compare(p2.cnt, p1.cnt);
        Collections.sort(freq, comp);

        // Build result string
        StringBuilder sb = new StringBuilder();
        for (Pair p : freq) {
            int cnt = p.cnt;
            while (cnt > 0) {
                sb.append(p.val);
                cnt--;
            }
        }

        return sb.toString();
    }
}


class Solution {
public String frequencySort(String s) {
        return FrequencySorter.sortByFrequency(s);
    }
}
