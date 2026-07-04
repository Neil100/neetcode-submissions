class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
        }

        int l=0;
        for(int r=0; r<s2.length(); r++) {
            char ch = s2.charAt(r);

            if(!map.containsKey(ch)) {
                while(l<r) {
                    map.put(s2.charAt(l), map.get(s2.charAt(l))+1);
                    l++;
                }
                l=r+1;
                length = s1.length();
            } else if(map.get(ch)==0) {
                while(ch!=s2.charAt(l)) {
                    map.put(s2.charAt(l), map.get(s2.charAt(l))+1);
                    length++;
                    l++;
                }
                l++;
            } else {
                length--;
                map.put(s2.charAt(r), map.get(s2.charAt(r))-1);
                if(length==0)
                    return true;
            }
        }

        return false;
    }
}
