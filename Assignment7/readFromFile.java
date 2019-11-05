import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class readFromFile {
    public String readFrom(String pathName) throws IOException {
        File f = new File(pathName);
        FileInputStream fis = new FileInputStream(f);
        String s = readFromStream(fis);
        fis.close();
        return s;

    }

    public String readFromStream(FileInputStream fis) throws IOException {
        String s = "";
        while(true){
            int x = fis.read();
            if (x==-1){
                break;
            }
            char c = (char) x;
            s +=c;
        }
        fis.close();
        return s;
    }
}
