import java.util.*;

/**
 * @author gefei
 */
public class DirectedGraph {

    // element with index x: list of indexes of adjacent vertices
    private List<Integer>[] edges;

    /**
     * @param n: number of vertices
     */
    public DirectedGraph(int n) {
        this.edges = new List[n];
        for (int i = 0; i < n; i++) {
            this.edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to) {
        edges[from].add(to);
    }

    public int getNumbVertices() {
        return edges.length;
    }
    public int getNumEdges(){
        int c=0;
        for (int i=0; i<getNumbVertices();i++){
            c+=edges[i].size();
        }
        return c;
    }
    public int getOutDegree(int n) {
        return edges[n].size();
    }
    public int getInDegree(int n){
        int in=0;
        for(int i=0; i<getNumbVertices(); i++){
            for(int child:edges[i]){
                if(child==n){
                    in++;
                }
            }
        }
        return in;
    }

    /**
     * @return if there is a path from vertex "from" to vertex "to"
     */
    public boolean connectedBfs(int from, int to) {
        Set<Integer> visited = new HashSet<>();//sortiert, doppelt nicht
        Queue<Integer> queue = new LinkedList<>();//nicht sortiert, darf doppeln
        queue.add(from);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (current == to) {
                return true;
            }
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            queue.addAll(edges[current]);
        }
        return false;
    }
    public boolean canReach(int[] arr, int start) {
        /*Queue<Integer> q= new LinkedList<>();BFS
        Set<Integer> v=new HashSet<>();
        q.add(start);
        while(!q.isEmpty()){
            int c=q.remove();
            if(arr[c]==0) return true;
            if(v.contains(c)) continue;
            v.add(c);
            int value=arr[c];
            if(start-value>=0) q.add(start-value);
            if(start+value<arr.length) q.add(start+value);

        }
        return false;*/
        int value=arr[start];
        if(!(value<0)){
            if(value==0) return true;
            arr[start]=-arr[start];
            if(start-value>=0 && canReach(arr, start-value)) return true;
            if(start+value<arr.length && canReach(arr, start+value)) return true;

        }
        return false;
    }

    public static void main(String[] args) {
        DirectedGraph g= new DirectedGraph(6);
        g.addEdge(0, 3);
        g.addEdge(0, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        g.addEdge(1, 4);
        g.addEdge(4, 2);
        g.addEdge(4, 5);
        g.addEdge(5, 2);
        System.out.println(g.getNumEdges());
        System.out.println(g.getOutDegree(0));
        System.out.println(g.getInDegree(4));
        System.out.println(g.connectedBfs(0, 4));

    }

}
