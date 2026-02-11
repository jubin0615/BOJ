import java.util.*;
import java.io.*;
public class Main {
    static int n,m,r,c,d, count;
    static int[][] room;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        room=new int[n][m];
        st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                room[i][j]=Integer.parseInt(st.nextToken());
        }
        count=0;
        dfs(r,c,d);
        System.out.println(count);
    }
    static void dfs(int y, int x, int direction) {
        if(room[y][x]==0){
            room[y][x]=2;
            count++;
        }
        for (int i = 0; i < 4; i++) {
            direction=(direction+3)%4;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if(nx>=0 && ny>=0 && nx<m && ny<n && room[ny][nx]==0){
                dfs(ny,nx,direction);
                return;
            }
        }
        int back=(direction+2)%4;
        int nx=x+dx[back];
        int ny=y+dy[back];
        if(nx>=0 && ny>=0 && nx<m && ny<n && room[ny][nx]!=1)
            dfs(ny,nx,direction);
    }
}
