import java.util.*;
public class Main {
    static ArrayList<Integer>[]A;
    static boolean visited[];
    static void DFS(int node){
        System.out.print(node+" ");
        visited[node]=true;
        for(int i:A[node]){
            if(!visited[i])
                DFS(i);
        }
    }
    static void BFS(int node){
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(node);
        visited[node]=true;
        while(!queue.isEmpty()){
            int now=queue.poll();
            System.out.print(now+" ");
            for (int i:A[now]){
                if (!visited[i]){
                    visited[i]=true;
                    queue.add(i);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int v=sc.nextInt();
        A=new ArrayList[n+1];
        for (int i=1; i<=n; i++)
            A[i]=new ArrayList<Integer>();
        for (int i=0; i<m; i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            A[x].add(y);
            A[y].add(x);
        }
        for (int i=1; i<=n; i++)
            Collections.sort(A[i]);
        visited=new boolean[n+1];
        DFS(v);
        System.out.println();
        visited=new boolean[n+1];
        BFS(v);
        System.out.println();
    }
}
