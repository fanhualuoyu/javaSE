package domain;

public class Demo15ReflectPerson {
    private String name;
    private int age;

    public String a;
    protected String b;
    String c;
    private String d;

    public Demo15ReflectPerson() {
    }

    public Demo15ReflectPerson(String name, int age) {
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


    @Override
    public String toString() {
        return "Demo15ReflectPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public void eat() {
        System.out.println("eat....");
    }

    public void eat(String str) {
        System.out.println("eat...." + str);
    }
}
