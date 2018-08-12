package vn.namnt;

import java.util.Stack;

public class Main {
    public static void main(String[] arg) {
        int d = 0;

        Status start = new Status(3, 3, 1);
        Status finish = new Status(0, 0, 0);
        Status ss[] = new Status[200];
        Status Q[] = new Status[200];
        int pi[] = new int[200];
        int L = 0, F = 0;
        Q[F] = start;
        ss[d++] = start;
        while (F <= L) {
            Status temp = Q[F++];
            if (temp.getK() == 1) {
                if (temp.getC() - 1 >= 0) {
                    Status temp1 = new Status(temp.getC() - 1, temp.getP(), 0);
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

    private static boolean duplicate(Status s[], Status temp, int n) {
        for (int i = 0; i < n; i++) {
            Status k = s[i];
            if (k.compare(temp)) {
                return false;
            }
        }
        return true;
    }

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
