package GFGBaseCodes;

import java.util.Scanner;

interface StateInterface {

    void a(ContextClass context);

    void b(ContextClass context);

    void c(ContextClass context);

}

class A implements StateInterface {
    @Override
    public void a(ContextClass context) {
        context.setState(new B());
    }

    @Override
    public void b(ContextClass context) {
        context.setState(new C());
    }

    @Override
    public void c(ContextClass context) {
        context.setState(new A());
    }

}

class B implements StateInterface {
    @Override
    public void a(ContextClass context) {
        context.setState(new A());
    }

    @Override
    public void b(ContextClass context) {
        context.setState(new C());
    }

    @Override
    public void c(ContextClass context) {
        context.setState(new A());
    }

}

class C implements StateInterface {
    @Override
    public void a(ContextClass context) {
        context.setState(new C());
    }

    @Override
    public void b(ContextClass context) {
        context.setState(new B());
    }

    @Override
    public void c(ContextClass context) {
        context.setState(new A());
    }

}

class ContextClass {
    private StateInterface state;

    public ContextClass(StateInterface initialState) {
        state = initialState;
    }

    protected void setState(StateInterface state) {
        System.out.println("State changed to: " + state.getClass().getSimpleName());
        this.state = state;
    }

    public StateInterface getState() {
        return state;
    }

    public void a() {
        state.a(this);
    }

}

public class Stateabc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sequence of states (A, B, C): ");
        String s = sc.nextLine();
        ContextClass context = new ContextClass(new A());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A')
                context.a();
            else if (s.charAt(i) == 'B')
                context.getState().b(context);
            else if (s.charAt(i) == 'C')
                context.getState().c(context);
        }
        sc.close();
        System.out.println("Final State: " + context.getState().getClass().getSimpleName());
    }
}
