package helllo.core.singleton;

public class StatefulService {
    private int price;
    // 공유필드는 항상 없는게 좋음 -> 지역변수로 하거나 해서 무상태성을 유지해야함 !! 변수를 공유하고 있기때문

    public void order(String name, int price){
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        this.price = price;

    }
    public int getPrice(){
        return price;
    }
}
