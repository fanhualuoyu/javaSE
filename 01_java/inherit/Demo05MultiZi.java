package inherit;

public class Demo05MultiZi extends Demo05MultiFu{

    public int num = 20;

    @Override
    public void method(){
        System.out.println("子类方法.");
    }

    public void methodZi(){
        System.out.println("子类特有方法.");
    }
}
