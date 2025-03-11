
import java.util.*;

public class EIPMOD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long mod = sc.nextLong();

        System.out.println(powerMod(n, k, mod));
    }

    static long powerMod(long n, long k, long mod) {
        long ans = 1;
        while (k > 0) {
            if ((k & 1) != 0) {
                ans = (ans * n) % mod;
            }
            n = (n * n) % mod;
            k >>= 1;
        }
        return ans;

    }
}
