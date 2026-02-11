import java.util.*;
import java.io.*;
public class Main {
    static int[][] map;
    static int n,m,max=0;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visited;
    static void dfs(int x, int y, int count, int sum){
        if(count==4){
            max=Math.max(max,sum);
            return;
        }
        for(int k=0; k<4; k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny]){
                if(count==2){  //ㅗ,ㅜ,ㅏ,ㅓ 모양을 완성하기 위함
                    visited[nx][ny]=true;
                    dfs(x,y,count+1,sum+map[nx][ny]);
                    visited[nx][ny]=false;
                }
                visited[nx][ny]=true;
                dfs(nx,ny,count+1,sum+map[nx][ny]);
                visited[nx][ny]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }

        visited=new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j]=true;
                dfs(i,j,1,map[i][j]);
                visited[i][j]=false;
            }
        }
        System.out.println(max);
    }
}
