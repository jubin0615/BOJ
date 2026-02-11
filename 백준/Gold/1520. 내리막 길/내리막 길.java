import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[][] map, dp;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int dfs(int x, int y){
        if(x==n-1 && y==m-1)
            return 1;
        if(dp[x][y]!=-1)
            return dp[x][y];    //이미 계산된 위치라면 저장된 값 사용

        dp[x][y]=0;   //출발지 (x,y)부터 목적지까지 가는 경로의 수 저장
        for(int k=0; k<4; k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]<map[x][y]){
                dp[x][y]+=dfs(nx,ny);  //다음 위치의 경로 수를 누적
            }
        }
        return dp[x][y];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        dp=new int[n][m];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                dp[i][j]=-1;
            }
        }
        System.out.println(dfs(0,0));
    }
}
