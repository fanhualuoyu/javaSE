package api;

import java.util.Arrays;

//System类
public class Demo08System {

    public static void main(String[] args) {
        //返回以毫秒为单位的当前时间
        System.out.println(System.currentTimeMillis());
        System.out.println("===========");

        /**
         * 将数组中指定的数据拷贝到另一个数组中
         * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
         *      src:原数组
         *      srcPos:原数组的起始位置
         *      dest:目标数组
         *      destPos:目标数组的起始位置
         *      length:要赋值的数组元素的数量
         */
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 10};
        System.out.println("复制前：" + Arrays.toString(dest));
        //把原数组的前三个元素复制到目标数组的前三个位置上
        System.arraycopy(src,0,dest,0,3);
        System.out.println("复制后：" + Arrays.toString(dest));
    }
}
