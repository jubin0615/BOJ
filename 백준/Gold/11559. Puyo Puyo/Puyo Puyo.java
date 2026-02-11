import java.io.*;
import java.util.*;
public class Main {
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static char[][] board;
    static int n=12, m=6;
    static boolean[][] visited;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        board=new char[n][m];
        for(int i=0; i<n; i++){
            String str=br.readLine();
            for(int j=0; j<m; j++)
                board[i][j]=str.charAt(j);
        }

        int count=0;
        while(true){
            boolean isFinished=true;
            visited=new boolean[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(board[i][j]!='.' && !visited[i][j]){
                        list=new ArrayList<>();  //각 문자마다 list 초기화
                        bfs(board[i][j],i,j);
                        if(list.size()>=4){
                            isFinished=false;  //연쇄 발생->다른 연쇄가 없는지 더 탐색
                            for(int k=0; k<list.size(); k++)
                                board[list.get(k)[0]][list.get(k)[1]]='.';
                        }
                    }
                }
            }
            if(isFinished) break;
            move();
            count++;
        }
        System.out.println(count);
    }
    static void move(){
        for(int j=0; j<m; j++){
            Queue<Character> q=new LinkedList<>();
            //아래에서부터 위로 올라가면서 뿌요를 큐에 넣고 해당 자리를 비움
            for(int i=n-1; i>=0; i--){
                if(board[i][j]!='.'){
                    q.add(board[i][j]);
                    board[i][j]='.';
                }
            }
            //큐에 저장된 뿌요들을 아래에서부터 다시 채움
            int idx=n-1;
            while(!q.isEmpty()){
                board[idx--][j]=q.poll();
            }
        }
    }
    static void bfs(char c, int x, int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        list.add(new int[]{x,y});
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] current=q.poll();
            int cx=current[0];
            int cy=current[1];
            for(int i=0; i<4; i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && board[nx][ny]==c){
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                    list.add(new int[]{nx,ny});
                }
            }
        }
    }
}
