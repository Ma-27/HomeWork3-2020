package Lv3;

public class JD implements PurchaseInterface {

    @Override
    public void receiveOrder() {
        System.out.println("已收到订单，请等待发货");
    }

    @Override
    public void deliverGoods() {
        try {
            Thread.sleep(1000);
            System.out.println("你的货物已发货");
        } catch (InterruptedException e) {
            System.out.println("出现未知错误");
            e.printStackTrace();
        }
    }

    @Override
    public void arrivalNotify() {
        try {
            Thread.sleep(3000);
            System.out.println("你的货物已经到达，请及时取件");
        } catch (InterruptedException e) {
            System.out.println("出现未知错误");
            e.printStackTrace();
        }
    }
}
