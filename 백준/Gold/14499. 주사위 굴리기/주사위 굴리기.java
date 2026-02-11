import java.io.*;
import java.util.*;
public class Main {
    static int n,m,x,y;
    static int[][] map;
    static int[] dx={0,0,0,-1,1};
    static int[] dy={0,1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }
        int[] dice=new int[6];
        int[] move=new int[k];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++)
            move[i]=Integer.parseInt(st.nextToken());

        int cx=x, cy=y;
        for(int movement:move){
            int nx=cx+dx[movement];
            int ny=cy+dy[movement];
            if(nx<0 || ny<0 || nx>=n || ny>=m ) continue;
            cx=nx;
            cy=ny;
            dice=rotateDice(dice,movement);

            if(map[cx][cy]==0)
                map[cx][cy]=dice[5];
            else {
                dice[5]=map[cx][cy];
                map[cx][cy]=0;
            }
            System.out.println(dice[0]);
        }
    }
    static int[] rotateDice(int[] dice, int direction){
        if(direction==1) return new int[]{dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]};
        if(direction==2) return new int[]{dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]};
        if(direction==3) return new int[]{dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]};
        return new int[]{dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]};
    }
}
