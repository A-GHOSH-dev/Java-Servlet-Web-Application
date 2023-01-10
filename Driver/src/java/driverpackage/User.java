package driverpackage;

public class User {

    String name;
    
    int age;
    
    int violations;

    public User(String name, int age,int violations) {
        super();
        this.name = name;
        this.age = age;
        this.violations= violations;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
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

    public int getViolations() {
        return violations;
    }

    public void setViolations(int violations) {
        this.violations = violations;
    }
    
    
}