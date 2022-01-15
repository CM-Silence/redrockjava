package redrockjava.test17;

//创建一个Student类装进列表中
public class Student {
    private String name;
    private String gender;
    private int age;

    Student(String name, String gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void introduce(){
        System.out.println("姓名:" + this.getName() + " ,性别:" + this.getGender() + " ,年龄:" + this.getAge());
    }

}
