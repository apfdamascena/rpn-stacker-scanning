import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileReader reader = new FileReader("/src/Calc1.stk");
        List<Token> tokens = reader.read();
        RPNStacker rpn = new RPNStacker();
        Token output = rpn.calculate(tokens);

        System.out.println("Saida: " + output.lexeme);

    }
}
