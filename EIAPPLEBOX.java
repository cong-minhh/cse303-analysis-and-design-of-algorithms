import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class EIAPPLEBOX {
    public static void main(String[] args) {
        int t = ni();
        StringBuilder res = new StringBuilder();
        // System.out.println(mergeSort(new long[] { 6, 5, 4, 6 }, 0, 3));
        while (t-- > 0) {
            int n = ni();
            long a = nl();
            long p = nl();
            long[] arr = new long[n];
            arr[0] = (a * a) % p;
            for (int i = 1; i < n; i++) {
                arr[i] = (arr[i - 1] * a) % p;
            }
            res.append(mergeSort(arr, 0, (n - 1))).append("\n");
        }
        System.out.println(res.toString());
    }

    public static long mergeSort(long[] arr, int low, int high) {
        long ans = 0;
        if (low < high) {
            int mid = (low + high) >> 1;
            ans += mergeSort(arr, low, mid);
            ans += mergeSort(arr, mid + 1, high);
            ans += merge(arr, low, mid, high);
        }
        return ans;
    }

    public static long merge(long[] arr, int low, int mid, int high) {
        long[] brr = new long[mid - low + 1];
        long[] crr = new long[high - mid];

        for (int i = 0; i < brr.length; i++) {
            brr[i] = arr[low + i];
        }
        for (int i = 0; i < crr.length; i++) {
            crr[i] = arr[mid + 1 + i];
        }
        long count = 0;
        int i = 0, j = 0, idx = low;
        while (i < brr.length && j < crr.length) {
            if (brr[i] <= crr[j]) {
                arr[idx++] = brr[i++];
            } else {
                arr[idx++] = crr[j++];
                count += brr.length - i;
            }
        }
        while (i < brr.length) {
            arr[idx++] = brr[i++];
        }
        while (j < crr.length) {
            arr[idx++] = crr[j++];
        }
        return count;
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
