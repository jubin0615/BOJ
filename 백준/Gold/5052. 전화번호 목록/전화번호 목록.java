import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String[] arr=new String[n];
            HashSet<String> set=new HashSet<>();

            for(int i=0; i<n; i++){
                String str=br.readLine();
                arr[i]=str;
                set.add(str);
            }
            boolean flag = true;
            for(int i=0; i<n; i++){
                for(int j=0; j<arr[i].length(); j++){
                    if(set.contains(arr[i].substring(0,j))){
                        flag=false;
                        break;
                    }
                }
            }
            if(!flag)
                System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
