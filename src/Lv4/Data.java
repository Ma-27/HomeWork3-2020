package Lv4;

public class Data {
    private String data;

    public Data(String data) {
        this.data = data;
    }

    public Data() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        System.out.println("数据已被保存到Data类中，数据的值为" + data);
    }
}


