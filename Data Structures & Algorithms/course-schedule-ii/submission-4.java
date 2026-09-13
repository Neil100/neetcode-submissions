class Solution {
    int[] order;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        // Set<Integer> nonDependent = new HashSet<>();
        order = new int[numCourses];
        index = 0;
        int[] coursesStatus = new int[numCourses]; // 0 -> not visited, 1 -> done, 2 -> in currentPath

        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
            // nonDependent.add(i);
        }

        for(int[] preq : prerequisites) {
            // nonDependent.remove(preq[0]);
            adjList.get(preq[0]).add(preq[1]);
        }

        for(int course=0; course<numCourses; course++) {
            if(!findOrder(course, adjList, coursesStatus)) {
                return new int[0];
            }
        }

        return order;
    }

    boolean findOrder(int course, List<List<Integer>> adjList, int[] coursesStatus) {

        if(coursesStatus[course]==2)
            return false;
        
        if(coursesStatus[course]==1)
            return true;

        coursesStatus[course] = 2;

        for(int newCourse : adjList.get(course)) {
            if(!findOrder(newCourse, adjList, coursesStatus)) {
                return false;
            }
        }
        coursesStatus[course] = 1;
        order[index++] = course;
        return true;
    }
}
