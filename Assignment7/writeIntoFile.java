import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class writeIntoFile {

    public void write(String pathName, String s) throws IOException {
        File f = new File(pathName);
        f.createNewFile();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(s.getBytes());
        fos.close();
    }
}
