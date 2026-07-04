class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int maxF = 0;
        char maxFChar='A';
        int l = 0;
        int sol = 0;
        for(int r=0; r<s.length(); r++) {
            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(maxF<map.get(ch)) {
                maxF = map.get(ch);
                maxFChar = ch;
            }
            
            while(r-l+1-maxF > k ) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)-1);
                l++;
            }

            sol = Integer.max(sol, r-l+1);
        }

        return sol;
    }
}
