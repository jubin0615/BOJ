import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int count=0;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }
        dfs(0,1,0);
        System.out.println(count);
    }
    static void dfs(int x, int y, int state){
        if(x==n-1 && y==n-1){
            count++;
            return;
        }
        if(state==0 || state==2){
            //가로
            if(y+1<n && map[x][y+1]==0)
                dfs(x,y+1,0);
        }
        if(state==1 || state==2){
            //세로
            if(x+1<n && map[x+1][y]==0)
                dfs(x+1,y,1);
        }
        if(y+1<n && x+1<n && map[x+1][y+1]==0 && map[x+1][y]==0 && map[x][y+1]==0) //대각선은 항상 검사
            dfs(x+1,y+1,2);
    }
}
