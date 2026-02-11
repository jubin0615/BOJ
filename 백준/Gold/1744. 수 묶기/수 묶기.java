import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minusPq=new PriorityQueue<>();
        PriorityQueue<Integer> plusPq=new PriorityQueue<>(Collections.reverseOrder());
        int count=0;
        for(int i=0; i<n; i++){
            int num=Integer.parseInt(br.readLine());
            if(num<=0)
                minusPq.add(num);
            else if(num>1)
                plusPq.add(num);
            else count++;
        }
        int minusSum=0;
        while(minusPq.size()>1){
            int num1=minusPq.poll();
            int num2=minusPq.poll();
            minusSum+=(num1*num2);
        }
        if(!minusPq.isEmpty())
            minusSum+=minusPq.poll();
        int plusSum=0;
        while(plusPq.size()>1) {
            int data1 = plusPq.poll();
            int data2 = plusPq.poll();
            plusSum += (data1 * data2);
        }
        if(!plusPq.isEmpty())
            plusSum+=plusPq.poll();
        int result=minusSum+plusSum+count;
        System.out.println(result);
    }
}