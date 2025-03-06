package CreationalPatterns;

final class SingletonClass {
    private static SingletonClass instance;

    private SingletonClass() {
    }

    public static synchronized SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}

public class SigletonPatternDemo {
    public static void main(String[] args) {
        SingletonClass singleton = SingletonClass.getInstance();
        singleton.showMessage();
    }
}
