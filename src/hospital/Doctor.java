package hospital;

public class Doctor extends Person{
    private String specialty ;

    // constructor
    public Doctor(String name,String userName,String password,int age,String specialty ) {
        super(name,userName,password,age);
        this.specialty = specialty;
    }


    // get specialty
    public String getSpecialty() {
        return specialty;
    }


    // set specialty
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


    // info
    @Override
    public String toString() {
        return ("""
                Doctor
                Name : %s
                age : %d
                Username: %s
                Specialty : %s
                """.formatted(name,age,userName,specialty));
    }
}
