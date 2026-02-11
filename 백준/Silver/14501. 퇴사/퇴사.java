import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] T=new int[n+1];
        int[] P=new int[n+1];
        int[] D=new int[n+2]; //i번째 날부터 퇴사일까지 벌 수 있는 최대 수입
        for(int i=1; i<=n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=n; i>0; i--){
            if(i+T[i]>n+1) D[i]=D[i+1];
            else D[i]=Math.max(D[i+1], P[i]+D[i+T[i]]);
        }
        System.out.println(D[1]);
    }
}
