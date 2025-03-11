import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

class EIUMEDARRAY4 {

    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        int t = ni();

        while (t-- > 0) {
            int n = ni();
            long a = nl();
            long p = nl();
            long k = nl();
            long arr[] = new long[n];
            arr[0] = (a * a) % p;
            for (int i = 1; i < n; i++) {
                arr[i] = (arr[i - 1] * a) % p;
            }

            res.append(quicksort(arr, 0, n - 1, k - 1)).append("\n");
        }
        System.out.println(res.toString());
    }

    public static long quicksort(long[] arr, int start, int end, long k) {
        int pivot = partition(arr, start, end);

        if (pivot == k) {
            return arr[pivot];
        } else if (pivot > k) {
            return quicksort(arr, start, pivot - 1, k);
        } else {
            return quicksort(arr, pivot + 1, end, k);
        }
    }

    public static int partition(long[] arr, int start, int end) {
        int mid = (start + end) >> 1;
        int median = calIndexMedian(arr, start, mid, end);
        swap(arr, median, end);
        int run = start;
        long pivot = arr[end];
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                swap(arr, run, j);
                run++;
            }
        }
        swap(arr, run, end);
        return run;
    }

    public static void swap(long[] arr, int i, int j) {
        long tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int calIndexMedian(long[] arr, int a, int b, int c) {
        if (arr[a] > arr[b]) {
            if (arr[b] > arr[c]) {
                return b;
            } else if (arr[a] > arr[c]) {
                return c;
            } else {
                return a;
            }
        } else {
            if (arr[a] > arr[c]) {
                return a;
            } else if (arr[b] > arr[c]) {
                return c;
            } else {
                return b;
            }
        }
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
