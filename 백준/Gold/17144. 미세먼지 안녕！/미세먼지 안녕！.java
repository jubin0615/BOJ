import java.io.*;
import java.util.*;

public class Main {
    static int[][] room;
    static int r,c,t; // t초가 지난 후 미세먼지의 양
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[] purifier=new int[2];

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());

        room=new int[r][c];
        int purifierIdx=0;
        for(int i=0; i<r; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0 ;j<c; j++){
                room[i][j]=Integer.parseInt(st.nextToken());
                if(room[i][j]==-1){
                    purifier[purifierIdx++]=i;
                }
            }
        }

        for(int i=0; i<t; i++){
            spread();
            purify();
        }

        System.out.println(totalDust());

    }
    static void spread(){
        int[][] temp=new int[r][c];

        for(int x=0; x<r; x++){
            for(int y=0; y<c; y++) {
                int amount = 0;
                int count = 0;
                if (room[x][y] > 0) {
                    amount = room[x][y] / 5;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx >= 0 && nx < r && ny >= 0 && ny < c && room[nx][ny] != -1) {
                            temp[nx][ny] += amount;
                            count++;
                        }
                    }
                }
                temp[x][y] += room[x][y] - amount * count;
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(room[i][j]!=-1)
                    room[i][j]=temp[i][j];
            }
        }

    }
    static void purify(){
        // 공기청정기 위쪽 (i:세로방향, j:가로방향)
        for(int i=purifier[0]-1; i>0; i--)
            room[i][0]=room[i-1][0];

        for(int j=0; j<c-1; j++)
            room[0][j]=room[0][j+1];

        for(int i=0; i<purifier[0]; i++)
            room[i][c-1]=room[i+1][c-1];

        for(int j=c-1; j>1; j--)
            room[purifier[0]][j]=room[purifier[0]][j-1];

        room[purifier[0]][1]=0;  // 공기청정기 바로 옆칸 0으로

        // 공기청정기 아래쪽
        for(int i=purifier[1]+1; i<r-1; i++)
            room[i][0]=room[i+1][0];

        for(int j=0; j<c-1; j++)
            room[r-1][j]=room[r-1][j+1];

        for(int i=r-1; i>purifier[1]; i--)
            room[i][c-1]=room[i-1][c-1];

        for(int j=c-1; j>1; j--)
            room[purifier[1]][j]=room[purifier[1]][j-1];

        room[purifier[1]][1]=0;  // 공기청정기 바로 옆칸 0으로
    }
    static int totalDust(){
        int sum=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(room[i][j]>0)
                    sum+=room[i][j];
            }
        }

        return sum;
    }
}
