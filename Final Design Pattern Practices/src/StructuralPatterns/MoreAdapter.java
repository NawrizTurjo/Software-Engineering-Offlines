package StructuralPatterns;

interface iTargettt{
    public void requestTarget();
}

class Adapteeee{
    public void specificRequest(){
        System.out.println("Specific Request");
    }
}

class Adapterrr implements iTargettt{

    private Adapteeee adaptee;
    
    public Adapterrr(Adapteeee adaptee){
        this.adaptee = adaptee;
    }
    
    @Override
    public void requestTarget() {
        adaptee.specificRequest();
    }

}

public class MoreAdapter {
   public static void main(String[] args) {
        Adapteeee adaptee = new Adapteeee();
        iTargettt target = new Adapterrr(adaptee);
        target.requestTarget();
   } 
}
