package base;

import inherit.Demo06InnerClass;

/**
 * 内部类：
 *  1.成员内部类：内用外，随意访问。外用内，需要内部类对象
 *  2.局部内部类(包含匿名内部类)：如果一个类定义在方法内部，那么这就是一个局部内部类
 * 权限修饰符：
 *  外部类：public/(default)
 *  成员内部类：public/protected/(default)/private
 *  局部内部类：什么都不能写
 */
public class Demo06InnerClassImpl {

    //成员内部类
    public class Heart{
        //内部类的方法
        public void beat(){
            System.out.println("内部类的方法");
            System.out.println("内部访问外部名字：" + name);
        }
    }

    //外部类的方法
    public void method(){
        System.out.println("外部类的方法.");
        new Heart().beat();
    }
    //外部类的变量
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 使用成员内部类的方法：
     *  1.间接方式：在外部类的方法当中，使用内部类；然后main只是调用外部类的方法
     *  2.直接方式：
     *          外部类名称.内部类名称   对象名 =  new 外部类名称.new 内部类名称()
     * @param args
     */
    public static void main(String[] args) {
        Demo06InnerClassImpl innerClass = new Demo06InnerClassImpl();
        // 间接方式
        innerClass.method();
        System.out.println("===============");
        //直接方式
        Demo06InnerClassImpl.Heart heart = new Demo06InnerClassImpl().new Heart();
        heart.beat();
        System.out.println("===============");
        //访问重名外部类变量
        Demo06InnerClassImpl.Inner inner = new Demo06InnerClassImpl().new Inner();
        inner.methodInner();
        System.out.println("===============");
        //局部内部类
        innerClass.methodOuter();
        System.out.println("================");
        /**
         * 匿名内部类:
         *      接口名称 对象名 = new 接口名称(){
         *        覆盖重写所有抽象方法
         *      }
         * 注意事项：
         *      接口名称是匿名内部类需要实现哪个接口
         */
        Demo06InnerClass anonymousClass = new Demo06InnerClass() {
            @Override
            public void AnonymousClass() {
                System.out.println("匿名内部类实现了");
            }
        };
        anonymousClass.AnonymousClass();
        System.out.println("================");
        //匿名对象
        new Demo06InnerClass(){
            @Override
            public void AnonymousClass() {
                System.out.println("匿名对象实现了.");
            }
        }.AnonymousClass();
    }

    int num = 10;//外部类的成员变量

    public class Inner{
        int num = 20; //内部类的成员变量
        public void methodInner(){
            int num = 30; //内部类的局部变量
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Demo06InnerClassImpl.this.num);
        }
    }

    // 局部内部类
    public void methodOuter(){
        final int outerNum = 20;// 所在方法的局部变量
        int outNum1 = 30;
        //outerNum = 20;
        // 局部内部类：如果希望访问所在方法的局部变量，那么这个局部变量必须是有效final的
        class methodOuterInner{
            int num = 10;
            public void mInner(){
                System.out.println(num);
                System.out.println(outerNum);
                System.out.println(outNum1);
            }
        }
        methodOuterInner methodOuterInner = new methodOuterInner();
        methodOuterInner.mInner();
    }

}
