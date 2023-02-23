package classwork;

public class Student {
    private String name;
    private Integer age;

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
        if (age>120||age<20){
            System.out.println("年龄录入有误");
            return;
        }
        this.age = age;
    }
    public void show(){
        System.out.println("name="+this.name+ " age="+this.age);
    }
}
class StudentTest{
    public static void main(String[] args) {
        Student st=new Student();
        st.setName("mlj");
        st.setAge(10);
        st.show();
    }
}