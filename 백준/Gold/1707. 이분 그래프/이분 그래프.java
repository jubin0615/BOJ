import java.util.*;
import java.io.*;
public class Main {
    static List<Integer>[] graph;
    static int[] check;
    static boolean isBipartite;
    static void dfs(int node, int color){    //color-> 미방문:0, 그룹: 1 또는 2
        check[node]=color;
        for(int i:graph[node]){
            if(check[i]==0)
                dfs(i, 3-color);
            else if(check[i]==color)
                isBipartite=false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        for(int i=0; i<test; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int v=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            graph=new ArrayList[v+1];
            for(int j=1; j<=v; j++)
                graph[j]=new ArrayList<>();

            check=new int[v+1];
            isBipartite=true;

            for(int p=0; p<e; p++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            for(int q=1; q<=v; q++){
                if(check[q]==0)
                    dfs(q,1);    //color-> 미방문:0, 그룹: 1 또는 2
            }
            System.out.println(isBipartite?"YES":"NO");
        }

    }
}
