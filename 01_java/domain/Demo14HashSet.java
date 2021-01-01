package domain;

import java.util.Objects;

public class Demo14HashSet {
    private String name;
    private Integer age;

    public Demo14HashSet() {
    }

    public Demo14HashSet(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo14HashSet hashSet = (Demo14HashSet) o;
        return Objects.equals(name, hashSet.name) &&
                Objects.equals(age, hashSet.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
