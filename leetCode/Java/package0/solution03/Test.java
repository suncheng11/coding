package package0.solution03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        test(list);
        list = new ArrayList<>();
        list.add(12);
        list.add(22);
        list.add(33);
        System.out.println(list);
    }

    public static void test(List<Integer> list) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程内:"+list);
            }
        }).start();
    }
}
