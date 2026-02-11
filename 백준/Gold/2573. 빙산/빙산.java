import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[][] iceberg;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visited;
    public static void meltIce(){     //빙산 녹이기
        int[][] melt=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(iceberg[i][j]>0){
                    int sea=0;
                    for(int k=0; k<4; k++){
                        int nx=i+dx[k];
                        int ny=j+dy[k];
                        if(nx>=0 && ny>=0 && nx<n && ny<m && iceberg[nx][ny]==0)
                            sea++;
                    }
                    melt[i][j]=sea;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                iceberg[i][j]=Math.max(iceberg[i][j]-melt[i][j], 0);
        }
    }
    public static int countIce(){   //덩어리 개수 세기
        visited=new boolean[n][m];
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && iceberg[i][j]>0){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int x, int y){  //덩어리 개수 세기
        visited[x][y]=true;
        for(int k=0; k<4; k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && iceberg[nx][ny]>0)
                dfs(nx,ny);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        iceberg=new int[n][m];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                iceberg[i][j]=Integer.parseInt(st.nextToken());
        }
        int year=0;
        while(true){
            int result=countIce();
            if(result>=2)
                break;
            else if(result==0){
                year=0;
                break;
            }
            meltIce();
            year++;
        }
        System.out.println(year);
    }
}
