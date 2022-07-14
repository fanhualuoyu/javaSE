package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合线程不安全的demo
 */
public class Demo01ContainerNotSafeDemo {
    public static void main(String[] args) {
        mapNotSafe();
    }

    public static void mapNotSafe() {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
            }, String.valueOf(i)).start();
        }
    }

    /**
     * set线程安全问题
     */
    public static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
            }, String.valueOf(i)).start();
        }
    }

    /**
     * list线程安全问题
     */
    public static void listNotSafe() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
            }, String.valueOf(i)).start();
        }

        /**
         * 1. 故障现象：
         *      java.util.ConcurrentModificationException
         * 
         * 2. 导致原因：
         *      并发争抢导致。例如：一个人正在写入，另外一个同学过来抢夺。
         * 
         * 3. 解决方案：
         *      3.1 Vector<String> list = new Vector<>();
         *      3.2 List<String> list = Collections.synchroizedList<>(new ArrayList<>());
         *      3.3 List<String> list = new CopyOnWriteArrayList<>();
         * 
         * 4. 写时复制
         *      CopyOnWrite容器即写时复制的容器。往一个容器里添加元素的时候，不直接往当前容器Object[]添加，而是先将
         *      当前容器Object[]进行Copy，复制出一个新的容器Object[] new Elements，然后新的容器Object[] new Elements
         *      里添加元素，添加完元素之后，再将原容器的引用指向新的容器setArray(newElements)；这样做的好处是CopyOnWrite
         *      容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读
         *      和写不同的容器。
         *      public boolean add(E e) {
                    final ReentrantLock lock = this.lock;
                    lock.lock();
                    try {
                        Object[] elements = getArray();
                        int len = elements.length;
                        Object[] newElements = Arrays.copyOf(elements, len + 1);
                        newElements[len] = e;
                        setArray(newElements);
                        return true;
                    } finally {
                        lock.unlock();
                    }
                }
         * 
         * 
         */
    }
}
