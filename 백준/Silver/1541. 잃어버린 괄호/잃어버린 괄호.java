import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String equation=br.readLine();
        String[] split=equation.split("-");
        int[] parts=new int[split.length];
        for(int i=0; i<split.length; i++){
            int part=0;
            part=changeFormat(split[i]);
            parts[i]=part;
        }
        int result=0;
        for(int i=1; i<parts.length; i++)
            result+=parts[i];
        System.out.println(parts[0]-result);
    }
    static int changeFormat(String s){
        String[] str=s.split("\\+");
        int sum=0;
        for(int i=0; i<str.length; i++){
            sum+=Integer.parseInt(str[i]);
        }
        return sum;
    }
}