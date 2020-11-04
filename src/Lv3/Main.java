package Lv3;

public class Main {
    public static void main(String[] args) {
        Me me = new Me();
        JD jd = new JD();
        me.addCallback(jd);

        //调用回调
        me.sendOrder();
        me.receiveLaptop();
    }
}
