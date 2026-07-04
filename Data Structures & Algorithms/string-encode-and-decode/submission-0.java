class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return new String(sb);
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)>='0' && str.charAt(i)<='9') {
                int length = 0;
                while(str.charAt(i)!='#') {
                    length = (str.charAt(i) - '0') + (length*10);
                    i++;
                }
                if(length==0) {
                    strs.add("");
                } else {
                    strs.add(str.substring(i+1, i+length+1));
                }
                i = i+length;
            }
        }

        return strs;
    }
}
