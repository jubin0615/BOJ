import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int)(max - min + 1);
        boolean[] notSquare = new boolean[size];

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = ((min + square - 1) / square) * square;

            for (long j = start; j <= max; j += square) {
                int idx = (int)(j - min);
                if (idx >= 0 && idx < size) { 
                    notSquare[idx] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (!notSquare[i]) count++;
        }

        System.out.println(count);
    }
}
