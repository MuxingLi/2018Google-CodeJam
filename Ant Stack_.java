import java.util.ArrayList;
import java.util.List;
class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder p = new StringBuilder();
        sb.append(1);
        int count=1;
        char say;
        for(int i=1;i<n;i++){//0-->1 1->11
            p=sb;
            sb=new StringBuilder();
            count=1;
            for(int j=0;j<p.length();j++){
                say=p.charAt(j);
                if(j!=p.length()-1 && p.charAt(j+1)==say){//j=last overwhelm
                    count++;
                }else{
                	sb.append(count);
                    sb.append(say);
                    count=1;
                }
            }
        }
        return sb.toString();
    }
}