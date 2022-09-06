import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        int i = 0;
        FileReader fileReader = new FileReader("system.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Iterator iterator  = bufferedReader.lines().iterator();
        while (iterator.hasNext()){
            System.out.println(""+i+":=> "+iterator.next());
            i++;
            if (i==100){
                break;
            }
        }
    }
}
