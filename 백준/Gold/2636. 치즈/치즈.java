import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int r,c;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        map=new int[r][c];
        for(int i=0; i<r; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int cheeseCount=0;
        int lastCheese=0;
        int time=0;

        while(true){
            cheeseCount=melt();
            if(cheeseCount==0) break;

            lastCheese=cheeseCount;
            time++;
        }

        System.out.println(time);
        System.out.println(lastCheese);

    }
    static int melt(){
        visited=new boolean[r][c];
        ArrayDeque<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{0,0});
        visited[0][0]=true;
        int count=0;  // 1시간 동안 녹인 치즈의 양

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            for(int i=0; i<4; i++){
                int nx=current[0]+dx[i];
                int ny=current[1]+dy[i];

                if(nx>=0 && nx<r && ny>=0 && ny<c && !visited[nx][ny]){
                    if(map[nx][ny]==0) {
                        visited[nx][ny]=true;
                        queue.add(new int[]{nx, ny});
                    }
                    else if(map[nx][ny]==1){
                        map[nx][ny]=0;
                        visited[nx][ny]=true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
