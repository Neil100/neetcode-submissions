class TimeMap {

    Map<String, List<Integer>> keyTimeStampMap;
    Map<Integer, String> timeStampValueMap;
    public TimeMap() {
        keyTimeStampMap = new HashMap<String, List<Integer>>();
        timeStampValueMap = new HashMap<Integer, String>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Integer> list = keyTimeStampMap.getOrDefault(key, new ArrayList<Integer>());
        list.add(timestamp);
        keyTimeStampMap.put(key, list);
        timeStampValueMap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        List<Integer> list = keyTimeStampMap.getOrDefault(key, new ArrayList<Integer>());

        if(list.size()==0)
            return "";

        int left = 0, right = list.size()-1;
        int ans=-1;
        while(left<=right) {
            int mid = (right-left) / 2 + left;

            if(list.get(mid)<=timestamp) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        // if(right==-1)
        //     return "";
        
        return ans==-1 ? "" : timeStampValueMap.get(list.get(right));
    }
}
