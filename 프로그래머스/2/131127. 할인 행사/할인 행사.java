import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> product=new HashMap<>();
        for(int i=0; i<want.length; i++){
            product.put(want[i], number[i]);
        }
        
        int result=0;
        for(int i=0; i+10<=discount.length; i++){
            HashMap<String, Integer> map=new HashMap<>();
            for(int j=i; j<i+10; j++){
                if(product.containsKey(discount[j]))
                    map.put(discount[j],map.getOrDefault(discount[j], 0)+1);
            }
            if(product.equals(map)) result++;
        }
        
        return result;
    }
}