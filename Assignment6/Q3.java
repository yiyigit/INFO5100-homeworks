import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public boolean isAnagram(String s, String t){
        Map<Character, Integer> h = new HashMap<>();
        for (int i=0; i<s.length();i++){
            if(!h.containsKey(s.charAt(i))){
                h.put(s.charAt(i),1);
            }else{
                h.put(s.charAt(i),h.get(s.charAt(i)) +1);
            }
        }

        for(int j=0;j<t.length();j++){
            if(!h.containsKey(t.charAt(j))){
                return false;
            }
            if (h.get(t.charAt(j))-1 <= 0){
                h.remove(t.charAt(j));
            }else {
                h.put(t.charAt(j), h.get(t.charAt(j)) - 1);
            }
        }
        if (h.size() == 0){
            return true;
        }return false;



    }

    public static void main(String[] args) {
        Anagram test = new Anagram();
        boolean a = test.isAnagram("rac","car");
        System.out.println(a);
    }
}
