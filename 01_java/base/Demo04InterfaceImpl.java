package base;

import inherit.Demo04Interface;

public class Demo04InterfaceImpl implements inherit.Demo04Interface {

    @Override
    public void methodAbs() {
        System.out.println("methodAbs方法.");
    }

    public static void main(String[] args) {
        Demo04InterfaceImpl inter = new Demo04InterfaceImpl();

        //默认方法
        inter.methodDefault();
        System.out.println("=============");

        //静态方法
        Demo04Interface.methodStatic();
        System.out.println("=============");

        //访问常量
        System.out.println(Demo04Interface.NUM);
    }
}
