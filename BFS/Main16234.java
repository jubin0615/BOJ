package Baekjoon;

import java.util.*;
import java.io.*;
public class Main16234 {
    static int n,l,r;
    static int[][] map;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visited;
    static List<int[]> list=new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());

        map=new int[n][n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }
        System.out.println(move());
    }
    static int move() { //이동 일 수 세기
        int count = 0;
        while(true){
            visited = new boolean[n][n];
            boolean isMove=false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum=bfs(i,j);
                        if(list.size()>1){   //연합이 형성된 경우
                            changePopulation(sum);
                            isMove=true;
                        }
                    }
                }
            }
            if(!isMove)
                break;
            count++;
        }
        return count;
    }
    static void changePopulation(int sum) {
        int avg=sum/list.size();
        for(int i=0; i<list.size(); i++){
            int[] t=list.get(i);
            map[t[0]][t[1]]=avg;
        }
    }
    static int bfs(int x, int y){
        Queue<int[]> q=new LinkedList<>();
        list=new ArrayList<>();

        q.add(new int[]{x,y});
        list.add(new int[]{x,y});
        visited[x][y]=true;
        int sum=map[x][y];

        while(!q.isEmpty()){
            int[] t=q.poll();
            for(int k=0; k<4; k++){
                int nx=t[0]+dx[k];
                int ny=t[1]+dy[k];
                if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny]){
                    int temp=Math.abs(map[t[0]][t[1]]-map[nx][ny]);
                    if(temp>=l && temp<=r){
                        sum+=map[nx][ny];
                        visited[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                        list.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return sum;
    }
}
