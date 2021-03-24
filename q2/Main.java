package q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamanho do array: ");
        
        int n = sc.nextInt();
        
        PriorityQueue priority_queue = new PriorityQueue(n);

        System.out.println("Elementos do array: ");

        for (int i = 0; i < n; i++) {
            System.out.printf("Valor %d: ", i+1);
            priority_queue.insert(sc.nextInt());
        }

        sc.close();
        
        priority_queue.print();
        
        priority_queue.printMaxValue();
    }
}
