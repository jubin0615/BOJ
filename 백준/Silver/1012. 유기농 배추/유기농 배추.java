import java.util.*;
import java.io.*;
public class Main {
    static int[][] cabbage;
    static boolean[][] visited;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int m,n;
    static void dfs(int a, int b){
        visited[a][b]=true;
        for(int k=0; k<4; k++){
            int x=a+dx[k];
            int y=b+dy[k];
            if(x>=0 && y>=0 && x<m && y<n && !visited[x][y] && cabbage[x][y]==1)
                dfs(x,y);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        for(int r=0; r<testCase; r++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            m=Integer.parseInt(st.nextToken());
            n=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken());
            cabbage=new int[m][n];
            visited=new boolean[m][n];

            for(int t=0; t<num; t++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                cabbage[x][y]=1;
            }
            int worm=0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j] && cabbage[i][j]==1){
                        dfs(i,j);
                        worm++;
                    }
                }
            }
            System.out.println(worm);
        }
    }
}