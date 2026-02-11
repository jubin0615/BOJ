import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        boolean[] prime=new boolean[2000000];
        for(int i=2; i<prime.length; i++)
            prime[i]=true;

        for(int i=2; i*i<prime.length; i++){
            if(!prime[i]) continue;
            for(int j=i*i; j<prime.length; j+=i)
                prime[j]=false;
        }

        for(int i=n; i<prime.length; i++){
            if(prime[i]&&palindrome(i)){
                System.out.println(i);
                break;
            }
        }
    }
    static boolean palindrome(int n){
        char[] numArr=String.valueOf(n).toCharArray();
        int start=0;
        int end=numArr.length-1;
        while(start<end){
            if(numArr[start]!=numArr[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}