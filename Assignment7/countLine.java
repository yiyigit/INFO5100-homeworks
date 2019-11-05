import java.io.BufferedReader;
import java.io.FileReader;

public class countLine {
    public static void main(String[] args) {
        for(int i = 0; i<args.length; i++){
            System.out.println(args[i] + ": ");
            count(args[i]);
        }
    }

    private static void count(String fileName) {
        BufferedReader in;
        int count = 0;
        try{
            in = new BufferedReader(new FileReader(fileName));
        }catch (Exception e){
            System.out.println("no such file");
            return;
        }
        try{
            String line = in.readLine();
            while(line != null){
                count ++;
                line = in.readLine();
            }
        }catch (Exception e){
            System.out.println("wrong");
            return;
        }
        System.out.println(count + "lines");

    }
}
