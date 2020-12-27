package base;

import inherit.Demo05MultiFu;
import inherit.Demo05MultiZi;

//多态：父类指向子类对象
public class Demo05Multi {
    /**
     * 向上转型：
     *  格式：
     *   父类名称 对象名 = new 子类名称()
     *   接口名称 对象名 = new 实现类名称()
     * 向下转型:对象一旦向上转型为父类，那么无法调用子类原有的特有内容
     *  子类名称 对象名 = (子类名称)父类对象
     */
    public static void main(String[] args) {
        //父类名称 对象名 = new 子类名称()
        Demo05MultiFu zi = new Demo05MultiZi();
        zi.method();
        zi.methodFu();
        System.out.println("============");
        System.out.println(zi.num);
        System.out.println("============");

        //向下转型
        Demo05MultiZi zi1 = (Demo05MultiZi) zi;
        zi1.methodZi();
        System.out.println("============");

        //instanceof的使用
        if (zi instanceof Demo05MultiZi){
            Demo05MultiZi zi2 = (Demo05MultiZi) zi;
            zi2.methodZi();
        }
        System.out.println("============");
        Demo05Multi.getMulti(zi);
    }

    public static void getMulti(Demo05MultiFu fu){
        if (fu instanceof Demo05MultiZi){
            ((Demo05MultiZi) fu).methodZi();
        }
    }

}
