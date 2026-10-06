class Solution {
    public int countAsterisks(String s) {
        int c = 0;
        boolean in = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '|') {
                in = !in;
            } 
            else if (ch == '*' && !in) {
                c++;
            }
        }

        return c;
    }
}