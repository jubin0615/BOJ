import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int card=sc.nextInt();
            pq.add(card);
        }
        int sum=0;
        while(pq.size()!=1){
            int card1=pq.poll();
            int card2=pq.poll();
            sum+=card1+card2;
            pq.add(card1+card2);
        }
        System.out.println(sum);
    }
}