import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[][] picture;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visited;
    public static int dfs(int x, int y){
        visited[x][y]=true;
        int area=1;
        for(int k=0; k<4; k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && picture[nx][ny]==1)
                area+=dfs(nx,ny);
        }
        return area;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        picture=new int[n][m];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                picture[i][j]=Integer.parseInt(st.nextToken());
        }
        visited=new boolean[n][m];
        int count=0;
        int max=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(picture[i][j]==1 && !visited[i][j]){
                    int area=dfs(i,j);
                    max=Math.max(area,max);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}
