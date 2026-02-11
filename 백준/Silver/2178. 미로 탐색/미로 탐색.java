import java.util.*;
import java.io.*;
public class Main {
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int n, m;
    static void BFS(int a, int b){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{a,b});
        visited[a][b]=true;
        while(!q.isEmpty()){
            int[] now=q.poll();
            for(int k=0; k<4; k++){
                int x=now[0]+dx[k];
                int y=now[1]+dy[k];
                if(x>=0 && y>=0 && x<n && y<m){
                    if(maze[x][y]!=0 && !visited[x][y]){
                        visited[x][y]=true;
                        maze[x][y]=maze[now[0]][now[1]]+1;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        maze=new int[n][m];
        visited=new boolean[n][m];
        for (int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            String line=st.nextToken();
            for(int j=0; j<m; j++)
                maze[i][j]=Integer.parseInt(line.substring(j,j+1));
        }
        BFS(0,0);
        System.out.println(maze[n-1][m-1]);
    }
}
