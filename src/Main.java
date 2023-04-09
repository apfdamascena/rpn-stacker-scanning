import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FileReader reader = new FileReader("/src/Calc1.stk");
        ArrayList<String> input = reader.read();
        RPNStacker rpn = new RPNStacker();

        Integer output = rpn.calculate(input);

        System.out.println("Saida: " + output);


    }
}
