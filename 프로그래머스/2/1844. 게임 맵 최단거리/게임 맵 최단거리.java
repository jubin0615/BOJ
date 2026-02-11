import java.util.*;

class Solution {
    private static final int[] dx={0,0,1,-1};
    private static final int[] dy={1,-1,0,0};

    public int solution(int[][] maps){
        int n=maps.length;
        int m=maps[0].length;
        int[][] dist=new int[n][m];   // 거리 저장 & 방문 여부 체크

        ArrayDeque<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{0,0});
        dist[0][0]=1;

        while(!queue.isEmpty()){
            int[] now=queue.poll();
            int x=now[0];
            int y=now[1];

            for(int i=0; i<4; i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(maps[nx][ny]==0) continue;  // 벽에 닿으면 패스

                if(dist[nx][ny]==0){
                    queue.add(new int[]{nx, ny});
                    dist[nx][ny]=dist[x][y]+1;
                }

            }
        }

        return dist[n-1][m-1]==0 ? -1:dist[n-1][m-1];
    }
}