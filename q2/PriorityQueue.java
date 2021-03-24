package q2;

public class PriorityQueue {
    public int[] heap;
    public int size;
    public int max_size;

    public PriorityQueue(int max_size) {
        this.max_size = max_size;
        this.size = 0;
        heap = new int[this.max_size + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    public int getParent(int pos) {
        return pos/2;
    }

    public int getLeftChild(int pos) {
        return (2 * pos);
    }

    public int getRightChild(int pos) {
        return (2 * pos) + 1;
    }

    public void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public void maxHeapify(int pos)
    {
        int left_child_index = getLeftChild(pos);
        int right_child_index = getRightChild(pos);

        int largest = pos;

        if ((left_child_index <= max_size) && (left_child_index>0)) {
            if (heap[left_child_index] > heap[largest]) {
                largest = left_child_index;
            }
        }

        if ((right_child_index <= max_size && (right_child_index>0))) {
            if (heap[right_child_index] > heap[largest]) {
                largest = right_child_index;
            }
        }

        if (largest != pos) {
            int aux = heap[largest];

            heap[largest] = heap[pos];
            
            heap[pos] = aux;
            
            maxHeapify(largest);
        }
    }

    public int maximum() {
        return heap[1];
    }

    public void increaseKey() {
        int current = size;

        while (heap[current] > heap[getParent(current)]) {
            swap(current, getParent(current));

            current = getParent(current);
        }
    }

    public void insert(int e) {
        size++;
        
        heap[size] = e;

        increaseKey();
    }
    
    public int extractMax() {
        int p = heap[1];
        
        heap[1] = heap[size--];
        
        maxHeapify(1);
        
        return p;
    }
    
    public void print() {
        for(int i=0;i<size;i++) {
            System.out.println(heap[i]);
        }
    }

    void printMaxValue() {
        System.out.println("Valor máximo: "+ extractMax());
    }
}
