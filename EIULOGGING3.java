import java.io.*;
import java.util.*;

class EIULOGGING3 {
    public static void main(String[] args) {
        int n = ni();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nl();
        }

        long[] dp = new long[n + 1];
        long[] dp2 = new long[n + 1];

        dp[1] = Math.max(arr[0], 0);
        if (n == 1) {
            System.out.println(dp[1] + " " + 1);
            return;
        }
        dp[2] = Math.max(dp[1], arr[1]);
        dp2[0] = 1;
        dp2[1] = 1;
        int mod = 1000000007;
        for (int i = 2; i <= n; i++) {
            if (dp[i - 2] + arr[i - 1] > dp[i - 1]) {
                dp[i] = dp[i - 2] + arr[i - 1];
                dp2[i] = dp2[i - 2];
            } else if (dp[i - 2] + arr[i - 1] < dp[i - 1]) {
                dp[i] = dp[i - 1];
                dp2[i] = dp2[i - 1];
            } else {
                dp[i] = dp[i - 1];
                dp2[i] = (dp2[i - 1] % mod + dp2[i - 2] % mod) % mod;
            }
        }
        System.out.println(dp[n] + " " + dp2[n]);
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
