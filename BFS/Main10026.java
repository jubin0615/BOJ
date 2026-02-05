package Baekjoon;

import java.io.*;
public class Main10026 {
    static char[][] color;
    static boolean[][] visited;
    static int n;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static void dfs(int x, int y, boolean isColorWeakness){
        visited[x][y]=true;
        for(int k=0; k<4; k++){
            int nx=x+dx[k];
            int ny = y +dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny]){
                if(isSameColor(color[nx][ny], color[x][y], isColorWeakness))   //색이 같다면 dfs로 계속 탐색
                    dfs(nx, ny, isColorWeakness);
            }
        }
    }
    static boolean isSameColor(char a, char b, boolean isColorWeakness){
        if(isColorWeakness){
            if((a=='R'||a=='G')&&(b=='R'||b=='G'))
                return true;
        }
        return a==b;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        color=new char[n][n];
        for(int i=0; i<n; i++){
            String str=br.readLine();
            for(int j=0; j<n; j++)
                color[i][j]=str.charAt(j);
        }
        visited=new boolean[n][n];
        int normalCount=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i,j,false);
                    normalCount++;
                }
            }
        }
        visited=new boolean[n][n];
        int weakCount=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i,j,true);
                    weakCount++;
                }
            }
        }
        System.out.println(normalCount+" "+weakCount);
    }
}
