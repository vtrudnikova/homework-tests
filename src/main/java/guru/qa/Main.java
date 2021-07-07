package guru.qa;

import guru.qa.object.MobilePhone;

public class Main {

    public static void main(String[] args) {
        MobilePhone mobilePhoneForSms = new MobilePhone("Phone", "yellow", true, 3);
        MobilePhone mobilePhoneForCall = new MobilePhone("LG", "Black", false, 2);
        MobilePhone mobilePhoneForPresent = new MobilePhone();

        mobilePhoneForSms.sendSms("Hello!What do you do?", "Mary", "Jack");
        mobilePhoneForCall.call("Mary", 89106001634L);

        System.err.println(mobilePhoneForCall.isSupportApplePay());
        mobilePhoneForCall.setSupportApplePay(false);

        System.err.println(mobilePhoneForCall.isSupportApplePay());
        System.out.println("MobilePhoneName.getName = " + mobilePhoneForPresent.getBrand());

        mobilePhoneForPresent.setBrand("IPhone XR");
        System.out.println("MobilePhoneName.getName = " + mobilePhoneForPresent.getBrand());
    }
}
