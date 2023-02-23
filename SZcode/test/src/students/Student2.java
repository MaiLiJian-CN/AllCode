package students;

public class Student2 {
    private String name;
    private int age;

    public Student2(String name, int age) {
        System.out.println("有参构造器");
        this.name = name;
        this.age = age;
    }

    public Student2() {
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

    public void show(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
}
