import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {

    public static void main(String[] args) {

        int[] result = merge(new int[]{1, 3, 5, 7, 8}, new int[]{2, 4, 6, 9, 10});
        System.out.println("Merged Array of Array 1: [1,3,5,7,8] and Array 2: [2,4,6,9,10] is - " + Arrays.stream(result).boxed().collect(Collectors.toList()));

    }

    static int[] merge(int[] a1, int[] a2) {
        int[] ans = new int[a1.length + a2.length];

        int i = 0, j = 0, k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                ans[k++] = a1[i++];
            } else {
                ans[k++] = a2[j++];
            }
        }
        while (i < a1.length) {
            ans[k++] = a1[i++];
        }
        while (j < a2.length) {
            ans[k++] = a2[j++];
        }
        return ans;
    }
}

