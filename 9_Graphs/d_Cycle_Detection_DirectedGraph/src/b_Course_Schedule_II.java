import java.util.*;
public class b_Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1 : Form Adjacency List and Indegree array
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for(int[] pre: prerequisites){
            int course = pre[0];
            int preReqCourse = pre[1];

            if(!adjList.containsKey(preReqCourse))
                adjList.put(preReqCourse, new ArrayList<>());

            adjList.get(preReqCourse).add(course);
            inDegree[course]++;
        }

        // Step 2 : FInd the course with Indegree 0 and add it in queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        int[] order = new int[numCourses];
        int i=0;
        int courseTaken = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            courseTaken ++;
            order[i] = current;
            for(int neighbor: adjList.getOrDefault(current, Collections.emptyList())){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.add(neighbor);
                }
            }
            i++;
        }
        // There is a cycle and all the course can't be completed
        if(courseTaken == numCourses){
            return order;
        }
        //Return empty array
        return new int[0];
    }

    public static void main(String[] args) {
        b_Course_Schedule_II sol = new b_Course_Schedule_II();

        // Example input: 4 courses, prerequisites: [ [1,0], [2,0], [3,1], [3,2] ]
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] result = sol.findOrder(numCourses, prerequisites);

        System.out.println("Course Order: " + Arrays.toString(result));
    }
}
