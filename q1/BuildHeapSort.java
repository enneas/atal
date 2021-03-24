package q1;

public class BuildHeapSort { 
    public int[] sort(int array[]) {
        int n = array.length;
        
        MaxHeap max_heap = new MaxHeap(array, n);

        max_heap.build();

        int i = 0;
        
        int v[] = new int[n];
        
        while (!max_heap.empty()) {
            v[i++] = max_heap.extract();
        }
        
        return v;
    }

    public void printArray(int array[]) {
        for (int x : array) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
