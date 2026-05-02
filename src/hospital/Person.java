package hospital;

public abstract class Person {

    protected String name;
    protected String userName;
    protected String password;
    protected int id;
    protected int age;


    // id Autoincrement




    // constructor
    public Person(String name,String userName,String password,int age){
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.age = age;

    }


    //get ID
    public int getId() {
        return id;
    }

    // set ID
    public void setId(int id){
        this.id = id;
    }

    // get Name
    public String getName() {
        return name;
    }


    // set name
    public void setName(String name) {
        this.name = name;
    }


    // get Username
    public String getUserName() {
        return userName;
    }


    // set Username
    public void setUserName(String userName) {
        this.userName = userName;
    }


    // get Password
    public String getPassword() {
        return password;
    }


    // set Password
    public void setPassword(String password) {
        this.password = password;
    }


    // get Age
    public int getAge() {
        return age;
    }


    // set Age
    public void setAge(int age) {
        this.age = age;
    }

    // info
    @Override
    public abstract String toString();


    }
