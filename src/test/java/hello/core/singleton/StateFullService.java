package hello.core.singleton;

public class StateFullService {

    private int price; //상태를 유지하는 필드.

    public void order(String name, int price){

        System.out.println("name = " + name + "price = " + price);
        this.price = price; // 여기가 문제!!!!!!!!!!!!!
    }

    // 주문서 값이 공유되는 것을 방지하려면 어덯게 해야하니??  해결책-----------------------
    public int order2(String name, int price){

        System.out.println("name = " + name + "price = " + price);

        return price;
    }
    // 주문서 값이 공유되는 것을 방지하려면 어덯게 해야하니??  해결책-----------------------


    public int getPrice(){
        return price;
    }

}
