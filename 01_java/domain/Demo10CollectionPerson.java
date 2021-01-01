package domain;

public class Demo10CollectionPerson implements Comparable<Demo10CollectionPerson>{

    private String name;
    private int age;

    public Demo10CollectionPerson() {
    }

    public Demo10CollectionPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写排序的规则
    @Override
    public int compareTo(Demo10CollectionPerson demo10CollectionPerson) {
        return this.getAge() - demo10CollectionPerson.getAge(); // 年龄升序
    }
}
