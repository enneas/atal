package radix;

import java.util.Arrays;
import java.util.Scanner;

class RadixSort {

    //
   public void count_sort(String[] array, int pos, char lower, char upper) {
       String[] b_array = new String[array.length];

        // 2 + 122 - 97 = 27
       int[] array_count = new int[2 + (upper - lower)];

       Arrays.fill(array_count, 0);

       // Incrementa a contagem usando cada índice
       for (int i = 0; i < array.length; i++) {
           int char_index = (array[i].length() - 1 < pos) ? 0 : ((array[i].charAt(pos) - lower) + 1);

           array_count[char_index]++;
       }

       // Armazena o último índice de posição do caractere para cada posição de string
       for (int i = 1; i < array_count.length; i++)
           array_count[i] = array_count[i - 1] + array_count[i];

       for (int i = array.length - 1; i >= 0; i--) {
           int char_index = (array[i].length() - 1 < pos) ? 0 : (array[i].charAt(pos) - lower) + 1;
           
           b_array[array_count[char_index] - 1] = array[i];
           
           array_count[char_index]--;
       }

       for (int i = 0; i < b_array.length; i++)
           array[i] = b_array[i];
    }

    public void radix_sort(String[] array, char lower, char upper) {
        int max_positon = 0;

        for (int i = 0; i < array.length; i++)
            if (array[i].length() - 1 > max_positon)
                max_positon = array[i].length() - 1;

        // Utilizando a rotina do count sort
        for (int i = max_positon; i >= 0; i--)
            count_sort(array, i, lower, upper);
    }

    public void print_array(String[] array, String str) {
        System.out.println(str + ":");
        
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);

        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Número de strings: ");
        
        int n = sc.nextInt();

        n = n + 1;
        
        System.out.print("String: ");
        
        String[] array = new String[n];
        
        for (int i = 0; i < array.length; i++)
            array[i] = sc.nextLine();

        sc.close();

        RadixSort radix_sort = new RadixSort();
        
        radix_sort.print_array(array, "Antes");

        radix_sort.radix_sort(array, 'a', 'z');

        radix_sort.print_array(array, "Depois");
    }
}

/* 

    Número de strings: 4
    Strings:
    china
    brasil
    russia
    argentina

    Antes:

    china
    brasil
    russia
    argentina

    Depois:

    argentina
    brasil
    china
    russia
*/