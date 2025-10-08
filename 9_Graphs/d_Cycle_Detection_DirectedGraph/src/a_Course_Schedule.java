import java.util.*;

public class a_Course_Schedule {

    public static boolean dfs(Map<Integer, List<Integer>> adjList, boolean[] inStack, boolean[] visited, int i){
        if(inStack[i])
            return true;
        if(visited[i])
            return false;
        visited[i] = true;
        inStack[i] = true;
        for(int neighbor : adjList.getOrDefault(i, Collections.emptyList())){
            if(dfs(adjList, inStack, visited, neighbor)){
                return false;
            }
        }
        inStack[i] = false;
        return false;
    }

    public static boolean canFinish(int numCourses, int[][]prerequisites){
        Map<Integer, List<Integer>> adjList = new HashMap();
        for(int[] prerequisite : prerequisites){
            int u = prerequisite[0];
            int v = prerequisite[1];
            if(!adjList.containsKey(v))
                adjList.put(v, new ArrayList<>());

            adjList.get(v).add(u);
        }
        boolean[] inStack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(dfs(adjList, inStack, visited, i)){
                return false;
            }
        }
        return true ;
        /*
        1) Using List of List

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ;i<numCourses ; i++){
            adjList.add( new ArrayList<>());
        }
        System.out.println(adjList);
        for(int[] prerequisite : prerequisites){
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }
        System.out.println(adjList);
        boolean[] inStack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i< numCourses; i++){
            if(dfs(adjList, inStack, visited, i)){
                return false;
            }
        }
        return true;
        */
    }

    public static void main(String[] args) {
        int[][] prerequisites1 = {{1, 0}, {0, 1}};
        int[][] prerequisites2 = {{1, 0}, {2, 1}, {3, 2}};

        System.out.println("Can finish courses (prerequisites1)? " + canFinish(2, prerequisites1)); // Expected: false
        System.out.println("Can finish courses (prerequisites2)? " + canFinish(4, prerequisites2)); // Expected: true
    }
}
