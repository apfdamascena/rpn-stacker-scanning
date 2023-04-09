import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    private final String path;

    public FileReader(String path){
        this.path = path;
    }

    public ArrayList<String> read(){
        String directory = System.getProperty("user.dir");
        String filepath = directory + this.path;

        File file = new File(filepath);
        ArrayList<String> input = new ArrayList<>();

        try (Scanner in = new Scanner(file, StandardCharsets.UTF_8)){
            while(in.hasNextLine()){
                String line = in.nextLine();
                input.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return input;
    }


}
