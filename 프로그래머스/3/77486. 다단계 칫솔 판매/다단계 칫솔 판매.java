import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parent =new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            parent.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> total=new HashMap<>();
        for(int i=0; i<seller.length; i++){
            String current=seller[i];
            int money=amount[i]*100;
            while(money>0 && !current.equals("-")){
                total.put(current, total.getOrDefault(current,0)+money-(money/10));
                current= parent.get(current);
                money/=10;
            }
        }
        int[] answer =new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            answer[i]=total.getOrDefault(enroll[i],0);
        }
        return answer;
    }
}