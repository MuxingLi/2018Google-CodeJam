import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Solution_ {
	public static StringBuilder newWord(int n ,int l,HashMap<Integer,String> a){
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> gen = new HashMap<>();
		//random
		Set<Integer> set = new LinkedHashSet<Integer>(); 
		Integer num = l;
		Integer range = n*l;
		Random ran = new Random();
		while(set.size() < num){
			Integer tmp = ran.nextInt(range); 
			set.add(tmp);
		}
		//set-->string
		
		Object[] values = set.toArray();
		//->word
		 for(int i = 0;i < values.length;i++){
			 String b=a.get(i);
			 sb.append(b);
		 }
		 return sb;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());//case num
		ArrayList<String> al = new ArrayList<>();
		int n = 0,l = 0;
		for (int i = 1; i <= t; ++i) {
			HashMap<String, Integer> Dword = new HashMap<>();
			HashMap<String, Integer> chara_ = new HashMap<>();
			HashMap<Integer, String> chara = new HashMap<>();
			//N&L
			String a = in.nextLine();
			String[] o = a.split("\\s+");
			n = Integer.parseInt(o[0]);
			l = Integer.parseInt(o[1]);
			for(int j=1;j<=n;j++) {
				String b = in.nextLine();
				Dword.put(b, j);//Desta word Map
				//put character in
				char[] c = b.toCharArray();
				for(int k=0;k<l;k++) {
					String s = String.valueOf(c[k]);
					chara_.put(s,(k+1)*j);
					chara.put((k+1)*j,s);
				}
			}
			//impos
			int len=chara_.size();
			//num=1-->p>len-l+num
			int sum=1;
			for(int q=1;q>=len;q++) {
				sum*=len;
			}
			if(n==sum) {
				al.add("Case #" + i + ": " + "-");
			}else if(l==1){
				al.add("Case #" + i + ": " + "-");
			}else {
				//out
				StringBuilder sb = newWord(n, l, chara);
				while(Dword.containsKey(sb)) {
					sb = newWord(n, l, chara);
				}
				al.add("Case #" + i + ": " + sb);
			}
		}
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
	}

}
