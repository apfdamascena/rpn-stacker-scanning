import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class RPNStacker {

    private final Calculator calculator = new Calculator();

    public Token calculate(List<Token> input){
        Iterator<Token> iterator = input.iterator();
        Stack<Token> stack = new Stack<>();

        Token output;

        while(iterator.hasNext()){
            Token token = iterator.next();

            if(stack.size() < 2) {
                output = token;
            } else {
                Token left = stack.pop();
                Token right = stack.pop();

                Integer rightNumber = Integer.parseInt(right.lexeme);
                Integer leftNumber = Integer.parseInt(left.lexeme);

                Integer afterOperation = calculator.calculate(token.lexeme, rightNumber, leftNumber);
                output = new Token(TokenType.NUM, afterOperation.toString());
            }

            stack.add(output);
        }

        return stack.pop();
    }
}
