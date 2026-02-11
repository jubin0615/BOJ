import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String input=br.readLine();
        String explode=br.readLine();
        int explodeSize=explode.length();

        // 스택을 StringBuilder로 구현
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char c=input.charAt(i);
            sb.append(c);

            if(sb.length()>=explodeSize){
                boolean isSame=true;

                for(int j=0; j<explodeSize; j++){
                    char c1=sb.charAt(sb.length()-explodeSize+j);
                    char c2=explode.charAt(j);

                    if(c1!=c2){
                        isSame=false;
                        break;
                    }

                }
                if(isSame) sb.delete(sb.length()-explodeSize, sb.length());

            }
        }

        // if(sb.length()==0) System.out.println("FRULA");
        // else System.out.println(sb);
        System.out.println(sb.isEmpty() ? "FRULA" : sb.toString());
    }
}

