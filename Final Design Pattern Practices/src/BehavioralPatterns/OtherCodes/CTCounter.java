package BehavioralPatterns.OtherCodes;

interface Counter {
    void count(Context context);
}

class UpCounter implements Counter {
    @Override
    public void count(Context context) {
        if (context.getCount() == 10) {
            context.setState(new DownCounter());
        } else {
            context.increment();
            System.out.println(context.getCount());
        }
    }
}

class DownCounter implements Counter {
    @Override
    public void count(Context context) {
        if (context.getCount() == 0) {
            context.setState(new UpCounter());
        } else {
            context.decrement();
            System.out.println(context.getCount());
        }
    }
}

class Context {
    private Counter counter;
    int countValue;

    public Context() {
        counter = new UpCounter();
        countValue = 0;
    }

    protected void setState(Counter counter) {
        this.counter = counter;
    }

    public void increment() {
        countValue++;
    }

    public void decrement() {
        countValue--;
    }

    public int getCount() {
        return this.countValue;
    }

    public void count() {
        counter.count(this);
    }
}

public class CTCounter {
    public static void main(String[] args) {
        Context context = new Context();
        for (int i = 0; i < 200; i++) {
            context.count();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
