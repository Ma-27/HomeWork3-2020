package Lv4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Scanner;

/**
 * FIXME：输入一个对象(不是字符串123吗？)，还有，String 和 int 属性不是在 Data类 new 的时候就确定了吗？难道还要用多态？
 */
public class Main {
    //要赋值进去的字符串
    static int target = 123;
    static String choice = "";
    //判断一下用哪个构造方法
    static boolean flag = true;

    public static void main(String[] args) {
        //不明白题目是啥意思，我来让用户做个选择吧
        System.out.println("是否采用默认值123？答是/否");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("是")
                || choice.equalsIgnoreCase("yes")
                || choice.equalsIgnoreCase("y")
                || choice.equalsIgnoreCase("shi")
                || choice.equalsIgnoreCase("s")) {
            new Main().setValue(target);
            flag = true;
        } else if (choice.equalsIgnoreCase("否")
                || choice.equalsIgnoreCase("no")
                || choice.equalsIgnoreCase("n")
                || choice.equalsIgnoreCase("f")
                || choice.equalsIgnoreCase("fou")) {

            //要不是int，就输入String型的类型
            System.out.println("输入你想输入的值");
            choice = scanner.nextLine();
            flag = false;
            new Main().setValue(choice);
        } else {
            System.out.println("请尝试重新输入");
        }


    }

    public void setValue(Object object) {
        Class<?> dataClass = null;
        Class<?> mainClass = null;
        Data data = null;
        Type valueType = null;

        //首先获取object的类型（Class）
        try {
            dataClass = Class.forName("Lv4.Data");
            //获取一个Main类的对象，用来确定数据类型
            mainClass = Class.forName("Lv4.Main");
            //获取所有constructor对象
            Constructor<?>[] dataConstructor = dataClass.getConstructors();
            /*
            //去获取所有constructor
            for (int i = 0; i < dataConstructor.length; i++) {
                System.out.println(dataConstructor[i]);
            }
             */

            //新建一个data对象
            data = (Data) dataConstructor[0].newInstance(object.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("未找到Data类，请重试");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("出现未知错误");
            e.printStackTrace();
            System.exit(1);
        }

        //之后通过反射获取object对应的类型的属性的数据类型（是int还是String）
        Field value = null;
        try {
            if (flag) {
                value = mainClass.getDeclaredField("target");
            } else {
                value = mainClass.getDeclaredField("choice");
            }

            valueType = value.getGenericType();
        } catch (NoSuchFieldException e) {
            System.out.println("没有该属性！");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("遇到未知问题");
            e.printStackTrace();
            System.exit(1);
        }

        //利用反射，根据属性的类型进行赋值
        if (valueType.toString().equals("class java.lang.String")) {
            System.out.println("存入的数据为String型");
            //给data属性设为String型
            data.setData(choice);
        } else if (valueType.toString().equals("int")) {
            System.out.println("存入的数据为int行，数据为" + target);
            //转为String型再赋给data属性
            data.setData(String.valueOf(target));
        }
    }
}
