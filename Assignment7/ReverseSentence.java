
import java.io.IOException;


public class ReverseSentence{

    public String reverse(String s){
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0;i--){
            sb.append(arr[i]);
            sb.append(" ");
            }
        return sb.toString();
    }



    public static void main(String[] args) throws IOException{
        ReverseSentence a = new ReverseSentence();
        String path = "src/q1.txt";
        readFromFile rd = new readFromFile();
        String s = rd.readFrom(path);
        System.out.println("old sentence is: " + s);
        String res = a.reverse(s);
        System.out.println("new sentence is: " + res);
        writeIntoFile wf = new writeIntoFile();
        wf.write("src/q1_res.txt", res);

    }
}

