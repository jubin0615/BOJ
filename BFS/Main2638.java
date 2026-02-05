package Baekjoon;

import java.util.*;
import java.io.*;
public class Main2638 {
    static int n,m;
    static int[][] map;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visited;
    public static void markAir(){    //bfs 탐색을 통해 외부 공기로 연결된 0을 따로 표시
        visited=new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] current=q.poll();
            int x=current[0];
            int y=current[1];
            for(int k=0; k<4; k++){
                int nx=x+dx[k];
                int ny=y+dy[k];
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && map[nx][ny]==0){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
    public static void meltCheese(){
        int[][] count=new int[n][m];
        markAir();
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    int airContact=0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny])
                            airContact++;
                    }
                    if(airContact>=2)
                        count[i][j]=1;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(count[i][j]==1)
                    map[i][j]=0;
            }
        }
    }
    public static boolean allMelt(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1)
                    return false;
            }
        }
        return true;
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
        int time=0;
        while(!allMelt()){
            meltCheese();
            time++;
        }
        System.out.println(time);
    }
}
