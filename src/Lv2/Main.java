package Lv2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("简易计算器");
        System.out.println("输入格式为：：x operate y");
        System.out.println("请输入表达式：");

        Scanner scanner = new Scanner(System.in);
        String initialString = scanner.nextLine();
        double initialNumber = 0;
        char operand = 0;
        double finalNumber = 0;
        double result = 0;

        String[] split = initialString.split(" ");
        try {
            for (int i = 0; i < split.length; i++) {
                switch (i) {
                    case 0 -> initialNumber = Integer.parseInt(split[i]);
                    case 1 -> operand = split[i].charAt(0);
                    case 2 -> finalNumber = Integer.parseInt(split[i]);
                    default -> System.out.println("你可能输入多了,系统只读取前面三个输入正确的字符");
                }
            }
        /*
                System.out.println(initialNumber);
                System.out.println(operand);
                System.out.println(finalNumber);
        */
            //进行计算
            result = new CalculateImplement().calculate(initialNumber, operand, finalNumber);
        } catch (NumberFormatException formatException) {
            System.out.println("你的输入格式不正确，请重试");
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("你的输入有问题，程序抛出异常");
        }

        //打印结果
        System.out.println("计算结果为：" + initialString + " = " + result);
    }
}
