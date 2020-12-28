package domain;

import java.time.Period;

public class Demo07ObjectPerson {
    private String name;
    private int age;

    public Demo07ObjectPerson() {
    }

    public Demo07ObjectPerson(String name, int age) {
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

    //重写toString方法
    @Override
    public String toString() {
        return "Demo07ObjectPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //重写equal方法
    @Override
    public boolean equals(Object obj){
        //传递this本身
        if (obj == this){
            return true;
        }
        //传递的为null
        if (obj == null){
            return false;
        }
        //防止ClassCastException
        if (obj instanceof Demo07ObjectPerson){
            Demo07ObjectPerson p = (Demo07ObjectPerson)obj;
            return this.name.equals(p.name) && this.age == p.age;
        }
        return false;
    }

}
