package vn.namnt;


public class Main {
    public static void main(String[] arg) {
        int d = 0;
        //Todo trạng thái bắt đầu
        Status start = new Status(3, 3, 1);
        //Todo trạng thái kết thúc
        Status finish = new Status(0, 0, 0);

        //todo mảng lưu trùng
        Status ss[] = new Status[200];
        //todo mảng queue
        Status Q[] = new Status[200];
        //todo mảng lưu vị trí đã đi trước đó
        int pi[] = new int[200];
        //todo late và first của queue
        int L = 0, F = 0;
        Q[F] = start;
        ss[d++] = start;
        while (F <= L) {
            Status temp = Q[F++];
            //todo thuyền bên 1
            if (temp.getK() == 1) {
                //todo trạng thái 1 đi 1 cướp
                if (temp.getC() - 1 >= 0) {
                    Status temp1 = new Status(temp.getC() - 1, temp.getP(), 0);
                    if (!temp1.isDie() && duplicate(ss, temp1, d)) {
                        //todo thêm vào queue
                        Q[++L] = temp1;
                        //todo ghi nhớ dể lát xuất ra
                        pi[L] = F - 1;
                        //todo lưu vào mảng để check duplicate
                        ss[d++] = temp1;
                    }
                    //todo nếu kết thúc thì xuất thôi
                    if (temp1.compare(finish)) {
                        outStatus(Q, pi, L);
                        break;
                    }
                }
                //todo trạng thái 2 đi 2 phú
                if (temp.getP() - 1 >= 0) {
                    Status temp1 = new Status(temp.getC(), temp.getP() - 1, 0);
                    if (!temp1.isDie() && duplicate(ss, temp1, d)) {
                        Q[++L] = temp1;
                        pi[L] = F - 1;
                        ss[d++] = temp1;
                    }
                    if (temp1.compare(finish)) {
                        outStatus(Q, pi, L);
                        break;
                    }
                }
                //todo trạng thái 3 đi 1 cướp 1 phú
                if (temp.getC() - 1 >= 0 && temp.getP() - 1 >= 0) {
                    Status temp1 = new Status(temp.getC() - 1, temp.getP() - 1, 0);
                    if (!temp1.isDie() && duplicate(ss, temp1, d)) {
                        Q[++L] = temp1;
                        pi[L] = F - 1;
                        ss[d++] = temp1;
                    }
                    if (temp1.compare(finish)) {
                        outStatus(Q, pi, L);
                        break;
                    }
                }
                //todo trạng thái 4 đi 2 phú
                if (temp.getP() - 2 >= 0) {
                    Status temp1 = new Status(temp.getC(), temp.getP() - 2, 0);
                    if (!temp1.isDie() && duplicate(ss, temp1, d)) {
                        Q[++L] = temp1;
                        pi[L] = F - 1;
                        ss[d++] = temp1;
                    }
                    if (temp1.compare(finish)) {
                        outStatus(Q, pi, L);
                        break;
                    }
                }
                //todo trạng thái 5 đi 2 cướp
                if (temp.getC() - 2 >= 0) {
                    Status temp1 = new Status(temp.getC() - 2, temp.getP(), 0);
                    if (!temp1.isDie() && duplicate(ss, temp1, d)) {
                        Q[++L] = temp1;
                        pi[L] = F - 1;
                        ss[d++] = temp1;
                    }
                    if (temp1.compare(finish)) {
                        outStatus(Q, pi, L);
                        break;
                    }
                }
            }
            //todo thuyền bên kia
            if (temp.getK() == 0) {
                if (temp.getC() + 1 <= 3) {
                    Status temp1 = new Status(temp.getC() + 1, temp.getP(), 1);
                    if (!temp1.isDie() && duplicate(ss, temp1, d)) {
                        Q[++L] = temp1;
                        pi[L] = F - 1;
                        ss[d++] = temp1;
                    }


                }
                if (temp.getP() + 1 <= 3) {
                    Status temp1 = new Status(temp.getC(), temp.getP() + 1, 1);
                    if (!temp1.isDie() && duplicate(ss, temp1, d)) {
                        Q[++L] = temp1;
                        pi[L] = F - 1;
                        ss[d++] = temp1;
                    }

                }
                if (temp.getC() + 1 <= 3 && temp.getP() + 1 <= 3) {
                    Status temp1 = new Status(temp.getC() + 1, temp.getP() + 1, 1);
                    if (!temp1.isDie() && duplicate(ss, temp1, d)) {
                        Q[++L] = temp1;
                        pi[L] = F - 1;
                        ss[d++] = temp1;
                    }

                }
                if (temp.getP() + 2 <= 3) {
                    Status temp1 = new Status(temp.getC(), temp.getP() + 2, 1);
                    if (!temp1.isDie() && duplicate(ss, temp1, d)) {
                        Q[++L] = temp1;
                        pi[L] = F - 1;
                        ss[d++] = temp1;
                    }

                }
                if (temp.getC() + 2 <= 3) {
                    Status temp1 = new Status(temp.getC() + 2, temp.getP(), 1);
                    if (!temp1.isDie() && duplicate(ss, temp1, d)) {
                        Q[++L] = temp1;
                        pi[L] = F - 1;
                        ss[d++] = temp1;
                    }

                }
            }
        }
    }

    //todo check trạng thái trùng lặp
    private static boolean duplicate(Status s[], Status temp, int n) {
        for (int i = 0; i < n; i++) {
            Status k = s[i];
            if (k.compare(temp)) {
                return false;
            }
        }
        return true;
    }

    //todo xuất ra đường đi
    private static void outStatus(Status Q[], int pi[], int L) {
        if (L == 0) {
            Status start = new Status(3, 3, 1);
            System.out.println(start);
        } else {
            outStatus(Q, pi, pi[L]);
            System.out.println(Q[L]);
        }
    }
}
