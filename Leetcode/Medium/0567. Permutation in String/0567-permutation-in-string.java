class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] check1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            check1[s1.charAt(i) - 97]++;
        }

        int[] check2 = new int[26];
        int start = 0;
        int end = s1.length() - 1;

        for (int i = start; i <= end; i++) {
            check2[s2.charAt(i) - 97]++;
        }

        if (Arrays.equals(check1, check2)) {
            return true;
        }

        start++;
        end++;

        while(end < s2.length()) {
            if (start != 0) {
                check2[s2.charAt(start - 1) - 97]--;
            }
            check2[s2.charAt(end) - 97]++;

            if (Arrays.equals(check1, check2)) {
                return true;
            }

            start++;
            end++;
        }

        return false;
    }
}