class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int tLength = t.length();
        for(char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int l=0;
        int solLength = Integer.MAX_VALUE;
        int[] indices = new int[]{0, 0};

        for(int r=0; r<s.length(); r++) {
            char cChar = s.charAt(r);
            if(map.containsKey(cChar)) {
                int count = map.get(cChar);
                count--;
                map.put(cChar, count);

                    if(count>=0)
                        tLength--;
                    if(tLength==0) {
                        // found a sol
                        while(l<r) {
                            char lChar = s.charAt(l);
                            if(map.containsKey(lChar)) {
                                int lCount = map.get(lChar);
                                if(lCount==0) {
                                    break;
                                } else if(lCount<0) {
                                    lCount++;
                                    map.put(lChar, lCount);
                                }
                            }
                            l++;
                        }
                        if(r-l+1 < solLength) {
                            solLength = r-l+1;
                            indices = new int[]{l, r};
                        }
                    }
            } else if (!map.containsKey(cChar) && l==r) {
                l++;
            }
        }
        System.out.println(indices[0]);
        System.out.println(indices[1]);
        return solLength == Integer.MAX_VALUE ? "" : s.substring(indices[0], indices[0]+indices[1]-indices[0]+1);
    }
}
