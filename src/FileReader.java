import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private final String path;

    public FileReader(String path){
        this.path = path;
    }

    public List<Token> read(){
        String directory = System.getProperty("user.dir");
        String filepath = directory + this.path;
        File file = new File(filepath);

        List<Token> tokens = new ArrayList<>();

        try (Scanner input = new Scanner(file)){

            while(input.hasNextLine()){
                String digit = input.nextLine();

                Token token;

                if(isValid(digit)) token = new Token(TokenType.NUM, digit);
                else if (digit.equals("+")) token = new Token(TokenType.PLUS, digit);
                else if (digit.equals("-")) token = new Token(TokenType.MINUS, digit);
                else if (digit.equals("*")) token = new Token(TokenType.STAR, digit);
                else if (digit.equals("/")) token = new Token(TokenType.SLASH, digit);
                else throw new Exception("Unknown Character");
                tokens.add(token);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return tokens;
    }

    public boolean isValid(String digit){
        return digit != null && digit.matches("[0-9]*");
    }


}
