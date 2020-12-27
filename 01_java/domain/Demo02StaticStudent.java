package domain;

public class Demo02StaticStudent {
    private int id;
    private String name;
    private int age;
    public static String room;
    private static int idCounter = 0; //计数器

    public Demo02StaticStudent() {
        idCounter++;
    }

    public Demo02StaticStudent(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "StaticStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
