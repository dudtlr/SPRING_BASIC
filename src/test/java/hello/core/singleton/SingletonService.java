package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //자바가 실행하면 이친구를 알아서 실행한다.

    public static SingletonService getInstance(){

        return instance;
    }

    //다른 곳에서 마음대로 생성자로 객체 생성 방지 => private
    private SingletonService() {

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
