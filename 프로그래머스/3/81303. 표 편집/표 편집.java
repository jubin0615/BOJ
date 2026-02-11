import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted=new Stack<>();

        int size=n;
        int cur=k;

        for(String move:cmd){
            if(move.startsWith("U")){
                cur=cur-Integer.parseInt(move.substring(2));
            }
            else if(move.startsWith("D")){
                cur=cur+Integer.parseInt(move.substring(2));
            }
            else if(move.startsWith("C")){
                deleted.push(cur);
                size--;
                if(cur==size) cur--;
            }
            else if(move.startsWith("Z")){
                int idx=deleted.pop();
                if(idx<=cur) cur++;
                size++;
            }
        }
        StringBuilder answer=new StringBuilder();
        for(int i=0; i<size; i++){
            answer.append('O');
        }
        while(!deleted.isEmpty()){
            int index=deleted.pop();
            answer.insert(index,'X');
        }

        return answer.toString();
    }
}