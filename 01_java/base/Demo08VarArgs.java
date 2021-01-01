package base;

//可变参数:数据类型已经知道，但是参数个数不知。
// 一个方法只能有一个可变参数。如果的方法的参数有多个，那么可变参数必须写在参数列表的末尾。
public class Demo08VarArgs {
    public static void main(String[] args) {
        int i = add(1,2,3,4,5,6);
        System.out.println(i);
        System.out.println("===============");

        method("string", 3.14, 1,2,3);
    }

    public static void method(String b, double c, int... a) {
        System.out.println(b +" " + c + " " + a);
    }

    //求和
    public static int add (int... arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
