import java.io.*;
import java.util.*;

class EIDIVIDE {

    static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        long n = nl();
        long l = nl();
        long r = nl();
        compute(n);
        System.out.println(countOnes(n, l, r));
    }

    public static long compute(long n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 0 || n == 1) {
            memo.put(n, 1L);
        } else {
            memo.put(n, 2 * compute(n >> 1) + 1);
        }
        return memo.get(n);

    }

    public static long countOnes(long x, long l, long r) {
        if (x == 0)
            return 0;
        if (x == 1)
            return (l <= 1 && 1 <= r) ? 1 : 0;
        long len_left = compute(x >> 1);
        long m = len_left + 1;
        long total = 0;

        long leftRun = l;
        long leftStop = Math.min(len_left, r);
        if (leftRun <= leftStop) {
            total += countOnes(x >> 1, leftRun, leftStop);
        }

        if (l <= m && m <= r) {
            total += (x % 2);
        }

        long rightRun = Math.max(l - m, 1);
        long rightStop = r - m;
        if (rightRun <= rightStop && rightStop >= 1) {
            total += countOnes(x >> 1, rightRun, rightStop);
        }
        return total;

    }

    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

    static int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }

    static double nd() {
        return Double.parseDouble(ns());
    }

    static char nc() {
        return (char) skip();
    }

    static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    static long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}
