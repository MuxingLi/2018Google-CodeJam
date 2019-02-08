import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution1 {
	public static int read(int x, String s) {
		int len = s.length();
		int count=0;
		char[] s1= s.toCharArray();
		if(check(s1)<=x)
			return 0;
		for(int i=len-1;i>0;i--) {
			if(s1[len-1]=='C')
				len--;
			if(s1[i]=='S'&&s1[i-1]=='C') {
				s1[i]='C';
				s1[i-1]='S';
				count++;
				//check
				if(check(s1)<=x)
					return count;
				else
					i=len;
			}			
			if(i==1&&check(s1)>x)
				return -1;			
		}
		return count-1;
		
	}

	public static int check(char[] n) {
		int re=0;
		int s=1;
		for(int i=0;i<n.length; i++) {
			if(n[i]=='S') {
				re+=s;
			}else {
				s*=2;
			}
		}
		return re;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		ArrayList<String> al = new ArrayList<>();
		for (int i = 1; i <= t; ++i) {
			String a = in.nextLine();
			String[] o = a.split("\\s+");
			int n = Integer.parseInt(o[0]);
			int re = read(n, o[1]);
			String result;
			if (re == -1) {
				result = "IMPOSSIBLE";
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
