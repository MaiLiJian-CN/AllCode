package SbTest;

public class StudenTest {
    public static void main(String[] args) {
        Students mlj = new Students("mlj", 18);
        Students hhh = new Students("hhh", 18);
        Students[] arrStudents= new Students[]{mlj, hhh};
        for (Students arrStudent : arrStudents) {
            System.out.println(arrStudent);
        }
    }
}

class Students{
    private String name;
    private Integer age;

    public Students(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Students() {
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
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
