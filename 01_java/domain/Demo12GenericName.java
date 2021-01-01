package domain;

//定义泛型
public class Demo12GenericName<E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    //定义泛型的方法
    public <M> void method(M m) {
        System.out.println(m);
    }

    //含有泛型的静态方法
    public static <M> void method2(M m) {
        System.out.println(m);
    }
}
