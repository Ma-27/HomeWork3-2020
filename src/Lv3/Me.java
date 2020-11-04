package Lv3;

public class Me {
    PurchaseInterface purchase;

    void addCallback(PurchaseInterface purchaseInterface) {
        this.purchase = purchaseInterface;
    }

    //发送订单
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
