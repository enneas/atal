package q1;

public class MaxHeap {
    private int n;
    private int array[];

    // heap de tamanho fixo
    public MaxHeap(int array[], int n) {
        this.array = new int[n];

        for (int i = 0; i < n; i++) {
            this.array[i] = array[i];
        }

        this.n = n;
    }

    private void swap(int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    // pior caso O(log(N))
    private void heapify(int node) {
        // o nó raiz será >= descendentes
        int left = (2 * node) + 1;

        boolean swapl = false, swapr = false;
            
        if (left < n) {
            // Filho a esquerda
            if(array[node] < array[left]) {
                swap(node, left);
                swapl = true;
            }
        }

        int right = (2 * node) + 2;

        if (right < n) {
            // Filho a direita
            if (array[node] < array[right]) {
                swap(node, right);
                swapr = true;
            }
        }

        if (swapl) {
            heapify(left);
        }

        if (swapr) {
            heapify(right);
        }

        // se nenhuma troca ocorrer, então se deduz que o filho a esquerda/direita está na posição correta.
    }

    // O(N)
    public void build() {
        // os primeiros N/2 podem ser folhas
        for (int i = n/2; i >= 0; i--) {
            heapify(i);
        }
    }

    // log(N)
    public int extract() {
        if (empty()) {
             throw new IllegalStateException("Ocorreu um erro!");
        }

        int max = array[0];
            
        array[0] = array[n - 1]; // último nó adicionado ao primeiro
            
        n--;
            
        heapify(0); // realimenta o nó raiz

        return max;
    }

    public boolean empty() {
        return n == 0;
    }
}