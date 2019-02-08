import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

	public static int divide(int[] n) {
		int len = n.length;
		if (len == 0) {
			return -1;
		} else if (len == 1) {
			return -1;
		} else if (len == 2) {
			if (n[0] > n[1])
				return 0;
		}
		int[] n1;
		if (len % 2 != 0) {
			n1 = new int[len / 2 + 1];
		} else {
			n1 = new int[len / 2];
		}
		int[] n2 = new int[len / 2];
		for (int i = 0; i < len; i += 2) {
			n1[i / 2] = n[i];
		}
		for (int i = 1; i < len; i += 2) {
			n2[i / 2] = n[i];
		}

		Arrays.sort(n1);
		Arrays.sort(n2);
		n = new int[len];
		for (int i = 0; i < n1.length; i++) {
			n[2 * i] = n1[i];
		}
		for (int i = 0; i < n2.length; i++) {
			n[2 * i + 1] = n2[i];
		}
		int j = judge(n);
		return j;
	}

	public static int judge(int[] n) {
		for (int i = 0; i < n.length - 1; i++) {
			if (n[i] > n[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		ArrayList<String> al = new ArrayList<>();
		for (int i = 1; i <= t; ++i) {
			int n = Integer.parseInt(in.nextLine());
			String a = in.nextLine();
			int[] m = new int[n];
			String[] o = a.split("\\s+");
			for (int j = 0; j < n; j++) {
				m[j] = Integer.parseInt(o[j]);
			}
			int re = divide(m);
			String result;
			if (re == -1) {
				result = "OK";
			} else {
				result = String.valueOf(re);
			}
			al.add("Case #" + i + ": " + result);
		}
		for (int k = 0; k < t; k++) {
			System.out.println(al.get(k));
		}
	}
}
