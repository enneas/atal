package minimizando_paradas;

import java.util.Scanner;

public class Main {

    public static int stopsRequired(int d, int m, int n, int positions[]) {
        int stops_required = 0;

        int go_to = m;

        for (int i = 0; i < n; i++) {

            if (go_to < positions[i]){
                // se não tiver gasolina suficiente para chegar a esta estação
                // reabastece na estação anterior
                if (i > 0) go_to = positions[i - 1] + m;

                // estah na primeira estação ou
                // mesmo depois de reabastecer na estação anterior, não pode chegar a esta parada
                if (i == 0 || go_to < positions[i]) return -1;

                // o reabastecimento necessário nesta estação
                stops_required++;
            }
        }

        // verifica se pode chegar ao destino final
        if (go_to < d) {
            go_to = positions[n - 1] + m;

            if (go_to < d) return -1;

            stops_required++;
        }

        return stops_required;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt(), m = sc.nextInt(), n = sc.nextInt();

        int[] positions = new int[n];

        int i = 0;

        while (i < n) {
             positions[i++] = sc.nextInt();
        }

        sc.close();

        System.out.println(stopsRequired(d, m, n, positions));
    }
}