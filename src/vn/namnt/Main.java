package vn.namnt;

import java.util.Stack;

public class Main {
    public static void main(String[] arg) {
        int d = 0;
        Status start = new Status(3, 3, 1);
        Status finish = new Status(0, 0, 0);
        Stack<Status> s = new Stack<>();
        Status ss[] = new Status[200];
        s.push(start);
        ss[d++] = start;
        while (!s.isEmpty()) {
            Status temp = s.peek();
            System.out.println(s.peek());
            s.pop();
            if (temp.getK() == 1) {
                if (temp.getC() - 1 >= 0) {
                    Status temp1 = new Status(temp.getC() - 1, temp.getP(), 0);
                    if (!temp1.isDie() && dulicate(ss, temp1, d)) {
                        s.push(temp1);
                        ss[d++] = temp1;
                    }
                    if (temp1.iss(finish)) {
                        System.out.println(temp1);
                        break;
                    }
                }
                if (temp.getP() - 1 >= 0) {
                    Status temp1 = new Status(temp.getC(), temp.getP() - 1, 0);
                    if (!temp1.isDie() && dulicate(ss, temp1, d)) {
                        s.push(temp1);
                        ss[d++] = temp1;
                    }
                    if (temp1.iss(finish)) {
                        System.out.println(temp1);
                        break;
                    }
                }
                if (temp.getC() - 1 >= 0 && temp.getP() - 1 >= 0) {
                    Status temp1 = new Status(temp.getC() - 1, temp.getP() - 1, 0);
                    if (!temp1.isDie() && dulicate(ss, temp1, d)) {
                        s.push(temp1);
                        ss[d++] = temp1;
                    }
                    if (temp1.iss(finish)) {
                        System.out.println(temp1);
                        break;
                    }
                }
                if (temp.getP() - 2 >= 0) {
                    Status temp1 = new Status(temp.getC(), temp.getP() - 2, 0);
                    if (!temp1.isDie() && dulicate(ss, temp1, d)) {
                        s.push(temp1);
                        ss[d++] = temp1;
                    }
                    if (temp1.iss(finish)) {
                        System.out.println(temp1);
                        break;
                    }
                }
                if (temp.getC() - 2 >= 0) {
                    Status temp1 = new Status(temp.getC() - 2, temp.getP(), 0);
                    if (!temp1.isDie() && dulicate(ss, temp1, d)) {
                        s.push(temp1);
                        ss[d++] = temp1;
                    }
                    if (temp1.iss(finish)) {
                        System.out.println(temp1);
                        break;
                    }
                }
            }
            if (temp.getK() == 0) {
                if (temp.getC() + 1 <= 3) {
                    Status temp1 = new Status(temp.getC() + 1, temp.getP(), 1);
                    if (!temp1.isDie() && dulicate(ss, temp1, d)) {
                        s.push(temp1);
                        ss[d++] = temp1;
                    }
                   
                }
                if (temp.getP() + 1 <= 3) {
                    Status temp1 = new Status(temp.getC(), temp.getP() + 1, 1);
                    if (!temp1.isDie() && dulicate(ss, temp1, d)) {
                        s.push(temp1);
                        ss[d++] = temp1;
                    }

                }
                if (temp.getC() + 1 <= 3 && temp.getP() + 1 <= 3) {
                    Status temp1 = new Status(temp.getC() + 1, temp.getP() + 1, 1);
                    if (!temp1.isDie() && dulicate(ss, temp1, d)) {
                        s.push(temp1);
                        ss[d++] = temp1;
                    }

                }
                if (temp.getP() + 2 <= 3) {
                    Status temp1 = new Status(temp.getC(), temp.getP() + 2, 1);
                    if (!temp1.isDie() && dulicate(ss, temp1, d)) {
                        s.push(temp1);
                        ss[d++] = temp1;
                    }

                }
                if (temp.getC() + 2 <= 3) {
                    Status temp1 = new Status(temp.getC() + 2, temp.getP(), 1);
                    if (!temp1.isDie() && dulicate(ss, temp1, d)) {
                        s.push(temp1);
                        ss[d++] = temp1;
                    }

                }
            }
        }
    }

    public static boolean dulicate(Status s[], Status temp, int n) {
        for (int i = 0; i < n; i++) {
            Status k = s[i];
            if (k.iss(temp)) {
                return false;
            }
        }
        return true;
    }
}
