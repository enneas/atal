package gerando_lista_classificados;

class Competitor implements Comparable<Competitor> {
    String name;
    int grade;
    int course[] = new int[3];

    public Competitor(String name, int grade, int a, int b, int c) {
        this.name = name;
        this.grade = grade;
        this.course[0] = a;
        this.course[1] = b;
        this.course[2] = c;
    }

    public int compareTo(Competitor st) {
        return this.grade - st.grade;
    }
}