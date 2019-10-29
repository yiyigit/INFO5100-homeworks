import java.util.*;

public class Q4 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        Set<Integer> set = new HashSet<>();
        for(int i: arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Integer value: map.values()){
            set.add(value);
        }
        return set.size() == map.size();
    }

    public static void main(String[] args) {
        Q4 test = new Q4();
        int[] a = new int[]{1,2,1,1,2,3};
        boolean res = test.uniqueOccurrences(a);
        System.out.println(res);
    }

}
