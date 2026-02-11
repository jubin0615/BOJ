import java.io.*;
import java.util.*;
public class Main {
    static int n,k,l;
    static int[][] map;
    static HashMap<Integer,String> hash=new HashMap<>();
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static List<int[]> snake=new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        k=Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            map[x-1][y-1]=1;
        }
        l=Integer.parseInt(br.readLine());
        for(int i=0; i<l; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            String c=st.nextToken();
            hash.put(x,c);
        }
        game();
    }
    static void game(){
        int time=0;
        int cx=0, cy=0, d=0;   //d:방향변환
        snake.add(new int[]{0,0});

        while(true){
            time++;
            int nx=cx+dx[d];
            int ny=cy+dy[d];
            if(isFinish(nx,ny))
                break;
            if(map[nx][ny]==1){
                map[nx][ny]=0;
                snake.add(new int[]{nx,ny});
            }
            else{
                snake.add(new int[]{nx,ny});
                snake.remove(0);
            }
            if(hash.containsKey(time)) {
                if (hash.get(time).equals("D")) {
                    d++;
                    if (d == 4)
                        d = 0;
                } else {
                    d--;
                    if(d==-1)
                        d=3;
                }
            }
            cx=nx;
            cy=ny;
        }
        System.out.println(time);
    }
    static boolean isFinish(int nx, int ny){
        if(nx>=n || ny>=n || nx<0 || ny<0)
            return true;

        for(int i=0; i<snake.size(); i++){
            int[] s=snake.get(i);
            if(nx==s[0] && ny==s[1])
                return true;
        }
        return false;
    }
}
