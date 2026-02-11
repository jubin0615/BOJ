import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] request=new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            request[i][0]=Integer.parseInt(st.nextToken());  //강의료
            request[i][1]=Integer.parseInt(st.nextToken());  //기한
        }
        Arrays.sort(request, (a,b)->a[1]-b[1]); //기한 기준 오름차순 정렬
        PriorityQueue<Integer> pq=new PriorityQueue<>(); //기한별 최대 강의료 저장
        for(int i=0; i<n; i++){
            if(pq.size()<request[i][1])
                pq.add(request[i][0]);
            else if(pq.peek()<request[i][0]){
                pq.poll();
                pq.add(request[i][0]);
            }
        }
        int totalFee=0;
        for(int fee:pq)
            totalFee+=fee;
        System.out.println(totalFee);
    }
}
