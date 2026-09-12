class Solution {
    Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++) {
            List<Integer> list;
            if(map.containsKey(prerequisites[i][0])) {
                list = map.get(prerequisites[i][0]);
            } else {
                list = new ArrayList<>();
            }
            list.add(prerequisites[i][1]);
            map.put(prerequisites[i][0], list);
        }
        // System.out.println(map);
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numCourses; i++) {
            if(!canFinish(i, set)) {
                return false;
            }
        }

        return true;
    }

    boolean canFinish(int course, Set<Integer> set) {
        if(set.contains(course))
            return false;

        List<Integer> list = map.get(course);
        list = map.computeIfAbsent(course, k -> new ArrayList<>());
        if(list.size()==0)
            return true;
        
        set.add(course);
        for(int i=0; i<list.size(); i++) {
            if(!canFinish(list.get(i), set)) {
                return false;
            } else {
                list.remove(i);
                i--;
            }
        }
        set.remove(course);
        return true;
    }
}
