package gerando_lista_classificados;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        String opted[] = new String[n];
        
        Arrays.fill(opted, "---");
        
        int v = sc.nextInt();
        int k = sc.nextInt();

        Competitor[] competitor = new Competitor[k];

        int ind = 0;

        while (ind < k) {
            competitor[ind++] = new Competitor(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        
        sc.close();
        
        Arrays.sort(competitor);
        
        // Utilizando a bordagem gulosa...
        for (int i = k-1; i >= 0; i--) {
            int course_option[] = competitor[i].course;
            
            for(int j = 0; j < 3; j++) {

                // Se o curso estiver disponível, dê ao aluno priorizado
                if (opted[course_option[j]-1] == "---") {
                    opted[course_option[j]-1] = competitor[i].name;
                    break;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println((i+1)+ " " + opted[i]);
        }
    }
}