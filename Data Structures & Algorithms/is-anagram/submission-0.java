class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] vectorS = new char[27];
        char[] vectorT = new char[27];
        Arrays.fill(vectorS, '0');
        Arrays.fill(vectorT, '0');

        for(int i=0; i<s.length(); i++) {
            vectorS[s.charAt(i)-'a']++;
            vectorT[t.charAt(i)-'a']++;
        }

        String sString = new String(vectorS);
        String tString = new String(vectorT);

        if(sString.compareTo(tString)==0)
            return true;
        return false;
    }
}
