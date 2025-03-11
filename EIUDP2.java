
import java.io.*;
import java.util.*;

public class EIUDP2 {

    public static void main(String[] args) {
        System.out.println(1 >> 2);
        int t = ni();
        StringBuilder res = new StringBuilder();
        while (t-- > 0) {
            int n = ni();
            int k = ni();
            long[] arr = new long[n];
            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) {
                arr[i] = nl();
                prefix[i + 1] = prefix[i] + arr[i];
            }

            long[] dp = new long[n + 1];
            for (int i = 1; i < k; i++) {
                dp[i] = prefix[i];
            }
            for (int i = k; i <= n; i++) {
                long sth = 0;
                for (int idx = i; idx > i - k; idx--) {
                    sth = Math.max(sth, dp[idx - k - 1 < 0 ? 0 : idx - k - 1] + (prefix[i] - prefix[idx - 1]));
                }
                dp[i] = Math.max(dp[i - 1], sth);
            }
            res.append(dp[n]).append("\n");

        }
        System.out.println(res.toString());

    }

    public static class SegmentTree {

        long[] trees;
        int n;

        public SegmentTree(long[] arr) {

            n = arr.length;
            trees = new long[4 * n + 1];
            build(1, 0, n - 1, arr);
        }

        void build(int node, int start, int end, long[] arr) {
            if (start == end) {
                trees[node] = arr[start];
            } else {
                int mid = (start + end) >> 1;
                build(2 * node, start, mid, arr);
                build(2 * node + 1, mid + 1, end, arr);

                trees[node] = trees[2 * node] + trees[2 * node + 1];
            }
        }

        long query(int node, int l, int r, int start, int end) {
            if (r < start || l > end) {
                return 0;
            }
            if (l >= start && r <= end) {
                return trees[node];
            }

            int mid = (l + r) << 1;
            long left = query(2 * node, l, mid, start, end);
            long right = query(2 * node + 1, mid, r, start, end);

            return left + right;
        }

        long update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                trees[node] = val;
            } else {
                int mid = (start + end) >> 1;
                if (idx < mid) {
                    
                }
            }
        }
    }

    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

    static int readByte() {
        if (lenbuf == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) {
                return -1;
            }
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
