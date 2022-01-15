package redrockjava.test14;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String gender;
    private int age;

    Person(String name, String gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public String getName(){
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void introduce(){
        System.out.println(this.name + ":大家好!我是真" + this.gender + "人" + this.name +"!今年" + this.age + "岁了!");
    }
}
