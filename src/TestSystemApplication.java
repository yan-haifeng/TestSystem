import view.LoginFrame;
import view.Welcome;

public class TestSystemApplication {
    public static void main(String[] args) {
        begin();
    }

    public static void begin(){
        LoginFrame loginFrame = new LoginFrame();
        Welcome welcome = new Welcome();

        Thread t;
        new Thread(()->{
            welcome.show();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            welcome.close();
            loginFrame.show();
        }).start();
    }
}
