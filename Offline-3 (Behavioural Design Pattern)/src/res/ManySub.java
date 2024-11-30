

import java.util.ArrayList;
import java.util.List;

interface iObs {
    void update();
}

class Obs1 implements iObs {
    @Override
    public void update() {
        System.out.println("Obs1 updated");
    }
}

class Obs2 implements iObs {
    @Override
    public void update() {
        System.out.println("Obs2 updated");
    }
}

class Obs3 implements iObs {
    @Override
    public void update() {
        System.out.println("Obs3 updated");
    }
}

interface iSub {
    void add(iObs o);

    void remove(iObs o);

    void notifyObs();
}

class Sub1 implements iSub {
    private List<iObs> obs = new ArrayList<>();

    @Override
    public void add(iObs o) {
        obs.add(o);
    }

    @Override
    public void remove(iObs o) {
        obs.remove(o);
    }

    @Override
    public void notifyObs() {
        System.out.println("Sub1 notifying");
        for (iObs o : obs) {
            o.update();
        }
    }
}

class Sub2 implements iSub {
    private List<iObs> obs = new ArrayList<>();

    @Override
    public void add(iObs o) {
        obs.add(o);
    }

    @Override
    public void remove(iObs o) {
        obs.remove(o);
    }

    @Override
    public void notifyObs() {
        System.out.println("Sub2 notifying");
        for (iObs o : obs) {
            o.update();
        }
    }
}

public class ManySub {
    public static void main(String[] args) {
        Sub1 sub1 = new Sub1();
        Sub2 sub2 = new Sub2();

        Obs1 obs1 = new Obs1();
        Obs2 obs2 = new Obs2();
        Obs3 obs3 = new Obs3();

        sub1.add(obs1);
        sub1.add(obs2);
        sub2.add(obs3);

        sub1.notifyObs();
        sub2.notifyObs();

        sub1.remove(obs1);
        sub1.notifyObs();
    }
}
