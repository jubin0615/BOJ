import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] words=new String[n];
        for(int i=0; i<n; i++)
            words[i]= br.readLine();

        System.out.println(getSum(words));
    }
    static int getSum(String[] words){
        int[] alphabet=new int[26];
        for(String word:words){
            int digit=word.length();
            for(char letter:word.toCharArray()){
                int index=letter-'A';
                alphabet[index]+= (int) Math.pow(10,digit-1);  //겹치는 알파벳 나올 수 있으니 누적합 해야함
                digit--;
            }
        }
        Arrays.sort(alphabet);
        int maxNum=9;
        int sum=0;
        for(int i=25; i>=0 && alphabet[i]>0; i--){
            sum+=alphabet[i]*maxNum;
            maxNum--;
        }
        return sum;
    }
}
