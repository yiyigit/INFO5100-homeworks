import java.util.Arrays;
public class Extra {
    public int[] solution(String s){
        int n = s.length();
        int left = 0;
        int right = n;
        int[] res = new int[n+1];
        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'I'){
                res[i] = left++;
            }else{
                res[i] = right--;
            }
        }
        res[n] =left;
        return res;
    }
    public static void main(String[] args) {
        Extra e = new Extra();

        System.out.println(Arrays.toString(e.solution("IIDD")));

    }
}
