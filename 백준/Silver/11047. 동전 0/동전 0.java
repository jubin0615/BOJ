import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] A=new int[n];
        for (int i=0; i<n; i++)
            A[i]=Integer.parseInt(br.readLine());
        int count=0;
        for (int i=n-1; i>=0; i--){
            if(A[i]<=k){
                count+=k/A[i];
                k=k%A[i];
            }
        }
        System.out.println(count);
    }
}