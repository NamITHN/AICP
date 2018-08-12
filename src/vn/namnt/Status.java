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

    //todo kiểm tra trạng thái
    boolean isDie() {
        if (this.c > this.p && this.p != 0){
            return true;
        }
        else if((3 - this.c > 3 - this.p) && ((3 - this.p) != 0))
        return true;
        return false;

    }

    //todo so sánh 2 đối tượng
    boolean compare(Status temp) {
        return this.c == temp.getC() && this.p == temp.getP() && this.k == temp.getK();
    }
}
