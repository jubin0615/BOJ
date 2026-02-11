import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] A=new int[n];
        for(int i=0; i<n; i++)
            A[i]=Integer.parseInt(st.nextToken());

        int[] dp1=new int[n];
        int[] dp2=new int[n];
        dp1[0]=A[0];
        dp2[0]=A[0];
        int result=A[0];
        for(int i=1; i<n; i++){
            dp1[i]=Math.max(A[i], dp1[i-1]+A[i]);  //삭제 안했을 때 최대합
            dp2[i]=Math.max(dp1[i-1],dp2[i-1]+A[i]); //삭제했을 때
            result=Math.max(result, Math.max(dp1[i],dp2[i]));
        }

        System.out.println(result);
    }
}
