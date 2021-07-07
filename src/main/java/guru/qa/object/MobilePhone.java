package guru.qa.object;

public class MobilePhone {
    private String brand = "Samsung";
    private String color = "Red";
    private boolean supportApplePay = true;
    private int numberCameras = 1;

    public MobilePhone(String brand, String color, boolean supportApplePay, int numberCameras) {
        this.brand = brand;
        this.color = color;
        this.supportApplePay = supportApplePay;
        this.numberCameras = numberCameras;
    }

    public MobilePhone() {

    }

    public void sendSms(String textMessage, String to, String from) {
        System.out.println(textMessage);
        System.out.println(to);
        System.out.println(from);
    }

    public void call(String name, Long numberPhone) {
        System.out.println(name);
        System.out.println(numberPhone);
    }

    public String getBrand() {
        return brand;
    }


    public boolean isSupportApplePay() {
        return supportApplePay;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public void setSupportApplePay(boolean supportApplePay) {
        this.supportApplePay = supportApplePay;
    }

}
