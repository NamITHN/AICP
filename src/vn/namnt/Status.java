package vn.namnt;

public class Status {
    private int c;
    private int p;
    private int k;

    public Status(int c, int p, int k) {
        this.c = c;
        this.p = p;
        this.k = k;
    }

    public Status() {
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "Status{" +
                "c=" + c +
                ", p=" + p +
                ", k=" + k +
                '}';
    }

    boolean isDie() {
        return this.c > this.p;
    }
    boolean iss(Status temp){
        return this.c == temp.getC() && this.p == temp.getP() && this.k == temp.getK();
    }
}
