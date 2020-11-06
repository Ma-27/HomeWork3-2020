package Lv3;

/**
 * 这个是个简单的回调类，它去回调接口中规定的方法
 * 但使用前必须调用purchase interface来进行初始化
 */
public class Me {
    PurchaseInterface purchase;

    //传入接口类的一个对象
    void addCallback(PurchaseInterface purchaseInterface) {
        this.purchase = purchaseInterface;
    }

    /**
     * 发送订单
     */
    void sendOrder() {
        //京东收到订单
        purchase.receiveOrder();
        //京东发货
        purchase.deliverGoods();
        //到货提醒
        purchase.arrivalNotify();
    }

    void receiveLaptop() {
        System.out.println("已拿到电脑");
    }

}
