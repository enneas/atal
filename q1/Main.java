package q1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamanho do array: ");

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Valor %d: ", i+1);
            arr[i] = sc.nextInt();
        }

        sc.close();

        BuildHeapSort build_sort = new BuildHeapSort();

        int array[] = build_sort.sort(arr);

        build_sort.printArray(array);
    }
}
