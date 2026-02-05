package Baekjoon;

import java.util.*;
import java.io.*;
public class Main14502 {
    static int n,m;
    static int[][] map;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[][] virusMap;
    static int max=0;
    static void dfs(int wall){
        if(wall==3){
            bfs();
            return;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){   //빈칸에 벽을 세움. 빈칸이 5개라고 하면 그 중에서 3개를 고르는 조합은
                    // 5C3=10가지 이므로 이 모든 경우를 dfs가 탐색하는 것.
                    map[i][j]=1;
                    dfs(wall+1);
                    map[i][j]=0;    //백트래킹
                }
            }
        }
    }
    static void bfs(){
        Queue<int[]> queue=new LinkedList<>();
        virusMap=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                virusMap[i][j]=map[i][j];
                if(virusMap[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            int x=temp[0];
            int y=temp[1];
            for(int k=0; k<4; k++){
                int nx=x+dx[k];
                int ny=y+dy[k];
                if(nx>=0 && ny>=0 && nx<n && ny<m && virusMap[nx][ny]==0){
                    virusMap[nx][ny]=2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(virusMap[i][j]==0)
                    count++;
            }
        }
        max=Math.max(count, max);
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
        dfs(0);   //dfs 완전탐색이라서 반복문 안돌려도 됨
        System.out.println(max);
    }
}
