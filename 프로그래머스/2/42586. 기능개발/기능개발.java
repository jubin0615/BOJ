import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n=progresses.length;
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            if((100-progresses[i])%speeds[i]!=0){
                arr[i]=(100-progresses[i])/speeds[i]+1;
            }
            else arr[i]=(100-progresses[i])/speeds[i];
        }

        ArrayList<Integer> answer=new ArrayList<>();
        int count=1;
        int maxDay=arr[0];
        for(int i=1; i<n; i++){
            if(arr[i]<=maxDay){
                count++;
            }
            else{
                answer.add(count);
                count=1;
                maxDay=arr[i];
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}