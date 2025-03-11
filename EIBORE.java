import java.io.*;
import java.util.*;

public class EIBORE {
    public static void main(String[] args) {
        int n = ni();
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = nl();
            map.put(num, map.getOrDefault(num, 0l) + 1);
        }
        TreeSet<Long> ts = new TreeSet<>(map.keySet());
        long[] dp = new long[ts.size() + 1];
        long first = ts.pollFirst();
        if (!ts.isEmpty() && ts.first() - first == 1) {
            dp[1] = Math.max(dp[0] + first * map.get(first), dp[0]);
        } else {
            dp[1] = dp[0] + (first * map.get(first));
        }
        dp[1] = Math.max(first * map.get(first), (first + 1) * map.getOrDefault(first + 1, 0l));
        int size = ts.size();
        for (int i = 2; i <= size; i++) {
            long curr = ts.pollFirst();

            if (!ts.isEmpty() && ts.first() - curr == 1) {
                dp[i] = Math.max(dp[i - 2] + ts.pollFirst(), dp[i - 1]);
            } else {
                dp[i] = dp[i - 1] + (curr * map.get(curr));
            }
        }
        System.out.println(dp[size - 1]);
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
