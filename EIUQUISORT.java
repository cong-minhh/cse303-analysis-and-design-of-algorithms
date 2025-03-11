import java.io.*;
import java.util.*;

class EIUQUISORT {

    public static void main(String[] args) {
        int n = ni();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nl();

        }
        quickSort(arr, 0, n - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(arr[i]).append("\n");
        }
        System.out.println(res.toString());
    }

    public static void quickSort(long[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int medianOfThree(long[] arr, int low, int mid, int high) {
        if ((arr[low] <= arr[mid] && arr[mid] <= arr[high]) || (arr[high] <= arr[mid] && arr[mid] <= arr[low]))
            return mid;
        else if ((arr[mid] <= arr[low] && arr[low] <= arr[high]) || (arr[high] <= arr[low] && arr[low] <= arr[mid]))
            return low;
        else
            return high;
    }

    public static int partition(long[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int median = medianOfThree(arr, low, mid, high);
        swapByIndex(arr, median, low);
        long pivot = arr[low];
        int l = low - 1;
        int r = high + 1;
        while (true) {
            do {
                l++;
            } while (arr[l] < pivot);
            do {
                r--;
            } while (arr[r] > pivot);
            if (l >= r) {
                return r;
            }
            swapByIndex(arr, l, r);

        }
    }

    public static void swapByIndex(long[] arr, int a, int b) {
        long tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
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
