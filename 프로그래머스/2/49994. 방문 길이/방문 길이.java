import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x=0;
        int y=0;

        HashSet<String> answer=new HashSet<>();
        for(int i=0; i<dirs.length(); i++){
            int cx=x;
            int cy=y;

            if(dirs.charAt(i)=='U' && y<5) y++;
            else if(dirs.charAt(i)=='D' && y>-5) y--;
            else if(dirs.charAt(i)=='R' && x<5) x++;
            else if(dirs.charAt(i)=='L'&& x>-5) x--;

            if(cx==x && cy==y) continue; 
            answer.add(cx+","+cy+"->"+x+","+y);
            answer.add(x+","+y+"->"+cx+","+cy);
        }
        return answer.size()/2;
    }

}