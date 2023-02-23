package PresonSample;

public class Student {
    private String sid;
    private String name;
    private String age;
    private String address;

     Student() {
    }

    public Student(String sid, String name, String age, String address) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.address = address;
    }


    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid =sid;
    }
    public String getName() {
        return name;
    }
    public void setName(String sid) {
        this.name =name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String sid) {
        this.age =age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String sid) {
        this.address =address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
