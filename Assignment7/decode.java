import java.io.IOException;
import java.util.Stack;

public class decode {
    public String decodeString(String s){

        char[] charsS = s.toCharArray();
        Stack<Integer> count = new Stack<>();
        Stack<String> res = new Stack<>();
        int curNum = 0;
        String curString = "";

        for(int i=0; i< charsS.length; i++){
            char c = charsS[i];
            if(c == '['){
                res.push(curString);
                count.push(curNum);
                curString = "";
                curNum  =0;
            }
            else if(c==']'){
                String prev = res.pop();
                int num = count.pop();
                StringBuilder tmp = new StringBuilder();
                tmp.append(prev);
                for(int j = 0; j< num;j++){
                    tmp.append(curString);
                }
                curString = tmp.toString();
            }
            else if(Character.isDigit(c)){
                curNum = curNum *10+ (c-'0');
            }
            else{
                curString += c;
            }


        }
        return curString;
    }

    public static void main(String[] args) throws IOException {
        decode a = new decode();
        readFromFile rd = new readFromFile();
        String s = rd.readFrom("src/q2.txt");
        System.out.println("input file: \n" + s + "\n");
        String res = a.decodeString(s);
        System.out.println("output file: \n" + res);
        writeIntoFile wf = new writeIntoFile();
        wf.write("src/q2_res.txt", res);
    }

}
