package Lv2;

public class CalculateImplement implements Calculate {

    @Override
    public double calculate(double x, char operate, double y) {
        double result = 0;
        switch (operate) {
            case '+' -> result = x + y;
            case '-' -> result = x - y;
            case '×', '*' -> result = x * y;
            case '÷', '/' -> result = x / y;
            default -> System.out.println("目前不支持你输入的运算符,或者你输入的运算符有误");
        }
        return result;
    }
}
