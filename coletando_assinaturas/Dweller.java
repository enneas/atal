package coletando_assinaturas;

public class Dweller implements Comparable<Dweller> {
    public int ts;
    public int tf;
    
    public Dweller(int ts,int tf){
        this.ts = ts;
        this.tf = tf;
    }

    @Override
    public int compareTo(Dweller o) {
        if (this.ts - o.ts == 0) {
            return this.tf - o.tf;
        }

        return this.ts - o.ts;
    }
}