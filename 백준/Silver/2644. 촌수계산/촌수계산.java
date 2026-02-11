import java.util.*;
import java.io.*;
public class Main {
    static List<Integer>[] relation;
    static boolean[] visited;
    static int result=-1;
    static void dfs(int start, int end, int count){
        if(start==end){
            result=count;
            return;
        }
        visited[start]=true;
        for(int i:relation[start]){
            if(!visited[i])
                dfs(i, end, count+1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(br.readLine());
        relation = new ArrayList[n + 1];
        for(int i=1; i<=n; i++)
            relation[i]=new ArrayList<>();

        visited=new boolean[n+1];
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            relation[a].add(b);
            relation[b].add(a);
        }
        dfs(x, y,0);
        System.out.println(result);
    }
}
