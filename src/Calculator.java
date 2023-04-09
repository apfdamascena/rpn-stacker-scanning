public class Calculator {


    public Integer calculate(String operator, Integer right, Integer left){
        if(operator.equals("+")) return right + left;
        if(operator.equals("-")) return right - left;
        if(operator.equals("*")) return right * left;

        if(left == 0) {
            System.out.println("Impossivel dividir por zero");
            return Integer.MAX_VALUE;
        }
        return right / left;
    }
}
