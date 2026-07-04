class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            set.add(s.charAt(i));
        }
        
        int sol = 0;
        int kvalue = k;
        for(char ch : set) {
            int l=0;
            k = kvalue;
            Queue<int[]> que = new LinkedList<>();
            for(int i=0; i<s.length(); i++) {
                char cch = s.charAt(i);

                if(ch != cch && kvalue!=0) {
                    if(k>0) {
                        k--;
                        sol = Integer.max(sol, i-l+1);
                    } else {
                        int[] array = que.poll();
                        l = array[1]+1;
                    }
                    que.add(new int[]{cch, i});
                } else if(ch != cch && kvalue == 0) {
                    l=i+1;
                } else {
                    sol = Integer.max(sol, i-l+1);
                }
            }
        }

        return sol;
    }
}
