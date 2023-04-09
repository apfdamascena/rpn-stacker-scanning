import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RPNStacker {

    private final Calculator calculator = new Calculator();

    public Integer calculate(ArrayList<String> input){
        Iterator<String> iterator = input.iterator();
        Stack<Integer> stack = new Stack<>();

        Integer output = 0;

        while(iterator.hasNext()){
            String token = iterator.next();

            if(stack.size() < 2) {
                output = Integer.parseInt(token);
            } else {
                Integer left = stack.pop();
                Integer right = stack.pop();

                output = calculator.calculate(token, right, left);
            }

            stack.add(output);
        }

        return stack.pop();
    }
}
