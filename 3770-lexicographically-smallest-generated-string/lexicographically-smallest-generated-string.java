class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        char[] word = new char[n + m - 1];
        
        // Step 1: fill with '?'
        for (int i = 0; i < word.length; i++) {
            word[i] = '?';
        }

        // Step 2: apply 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                    } else {
                        return ""; // conflict
                    }
                }
            }
        }

        // Step 3: fill remaining '?' with 'a'
        for (int i = 0; i < word.length; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // Step 4: fix 'F' violations
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // If invalid match → break it
                if (match) {
                    boolean broken = false;

                    // try to change from rightmost (safe)
                    for (int j = m - 1; j >= 0; j--) {
                        int idx = i + j;

                        // change to next char
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != word[idx]) {
                                char old = word[idx];
                                word[idx] = c;

                                // check all T again (must not break them)
                                if (validT(word, str1, str2)) {
                                    broken = true;
                                    break;
                                }

                                word[idx] = old;
                            }
                        }

                        if (broken) break;
                    }

                    if (!broken) return "";
                }
            }
        }

        return new String(word);
    }

    private boolean validT(char[] word, String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}