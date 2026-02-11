import java.util.*;

class Solution {
    private static char[][] map;
    private static int n,m;

    private static class Point{
        int nx, ny;
        public Point(int nx, int ny){
            this.nx = nx;
            this.ny = ny;
        }
    }

    private static int[] dx={0,0,1,-1};
    private static int[] dy={1,-1,0,0};

    public int solution(String[] maps){
        n=maps.length;
        m=maps[0].length();
        map=new char[n][m];
        for(int i=0; i<n; i++){
            map[i]=maps[i].toCharArray();
        }

        Point start=null, end=null, lever=null;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]=='S') start=new Point(j, i);
                else if(map[i][j]=='E') end=new Point(j, i);
                else if(map[i][j]=='L') lever=new Point(j, i);
            }
        }
        
        int startToLever=bfs(start, lever);
        int leverToEnd=bfs(lever, end);
        
        if(startToLever==-1 || leverToEnd==-1) return -1;
        else return startToLever+leverToEnd;

    }
    private static int bfs(Point start, Point end){
        int[][] dist=new int[n][m];
        ArrayDeque<Point> queue=new ArrayDeque<>();
        queue.add(start);
        dist[start.ny][start.nx]=1;  // 최단 거리 저장 및 방문 여부 체크

        while(!queue.isEmpty()){
            Point now=queue.poll();

            for(int i=0; i<4; i++){
                int x=now.nx+dx[i];
                int y=now.ny+dy[i];

                if(x<0 || y<0 || x>=m || y>=n) continue;
                if(map[y][x]=='X') continue;
                if(dist[y][x]>0) continue;   // 이미 방문한 지점인 경우 탐색 X
                
                dist[y][x]=dist[now.ny][now.nx]+1;
                queue.add(new Point(x, y));
                
                if(x==end.nx && y==end.ny) {
                    return dist[end.ny][end.nx]-1;   // 도착 지점 도달했다면 최단 거리 반환
                }
                
            }
        }
        
        return -1;  // 도착 지점 도달 못한 경우
    }
}