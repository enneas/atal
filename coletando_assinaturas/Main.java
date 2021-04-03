package coletando_assinaturas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        Dweller[] dwellers = new Dweller[n];

        int i = 0;

        while (i < n) {
            dwellers[i++] = new Dweller(sc.nextInt(), sc.nextInt());
        }

        sc.close();
        
        Arrays.sort(dwellers);
        
        ArrayList<Integer> visit_times  = new ArrayList<>();

        int index = 0;
        
        while (index < n) {
            int k = dwellers[index].tf;

            int min = k;
            
            index++;
            
            while (index < n) {
                if (dwellers[index].ts > k) break; 

                min = Math.min(min, dwellers[index].tf);

                index++; 
            }

            visit_times.add(min);
        }

        int count_visits = visit_times.size();

        System.out.println(count_visits);
        
        for (int visits : visit_times) {
            System.out.print(visits + " ");
        }

        System.out.println("\n");
    }
}