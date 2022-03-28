package helllo.core.singleton;

public class Singletonservice {
    // 이런식으로 설계를 해두면 인스턴스는 하나만 생성되고 자동으로 static 변수에 담겨짐
    // 그리고 private 생성자이기때문에 외부에서 생성을 할수가 없음!!!!!
    private static final Singletonservice instance = new Singletonservice();

    public static Singletonservice getInstance(){
        return instance;
    }

    private Singletonservice(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
