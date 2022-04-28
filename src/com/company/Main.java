package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Arrays.toString(args));
        String str = args[0];
            String[] p = str.split("\\D+");
            int a = Integer.parseInt(p[0]);
            int b = Integer.parseInt(p[1]);
            int c = Integer.parseInt(p[2]);
            int d = Integer.parseInt(p[3]);
            Fs fs = new Fs(a, b);
            Fs fs1 = new Fs(c, d);
            String[] q = str.split("\\d+");
            char op = q[2].charAt(0);
            switch (op) {
                case '+':
                    fs = fs.add(fs1);
                    break;
                case '-':
                    fs = fs.sub(fs1);
                    break;
                case '*':
                    fs = fs.nul(fs1);
                    break;
                case '\\':
                    fs = fs.div(fs1);
                    break;
            }
            System.out.println(fs);
    }

    static class Fs {
        int fz, fm;

        public Fs(int x, int y) {
            fz = x;
            fm = y;
        }

        public Fs add(Fs fs) {
            int Fz = fz * fs.fm + fm * fs.fz;
            int Fm = fm * fs.fm;
            return new Fs(Fz, Fm);
        }

        public Fs sub(Fs fs) {
            int Fz = fz * fs.fm - fm * fs.fz;
            int Fm = fm * fs.fm;
            return new Fs(Fz, Fm);
        }

        public Fs nul(Fs fs) {
            int Fz = fz * fs.fz;
            int Fm = fm * fs.fm;
            return new Fs(Fz, Fm);
        }

        public Fs div(Fs fs) {
            int Fz = fz * fs.fm;
            int Fm = fm * fs.fz;
            return new Fs(Fz, Fm);
        }

        public int gcd (int n, int m) {// Найти наименьшее общее кратное
            int r = n % m;
            while (r != 0) {
                n = m;
                m = r;
                r = n % m;
            }
            return m;
        }

        public String toString() {
            int d = gcd(fz, fm);
            fz /= d;
            fm /= d;
            String str = fz * fm < 0 ? "-" : "";
            if (fz % fm == 0) {
                str += Math.abs (fz / fm); // Абсолютное значение
            } else {
                str += Math.abs(fz) + "/" + Math.abs(fm);
            }
            return str;
        }
    }
}
