class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] str = text.toCharArray();

        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for (char ch : str) {
            if (ch == 'b') b++;
            else if (ch == 'a') a++;
            else if (ch == 'l') l++;
            else if (ch == 'o') o++;
            else if (ch == 'n') n++;
        }

        l /= 2; 
        o /= 2; 

        int count = Math.min(b,
                    Math.min(a,
                    Math.min(l,
                    Math.min(o, n))));

        return count;
    }
}