package hospital;
import java.util.ArrayList;
import java.util.List;
public class Patient extends Person{

    protected int Doctor_id;


    // constructor
    public Patient(String name , String userName , String password , int age , int Doctor_id){
        super(name , userName , password , age);
        this.Doctor_id = Doctor_id;

    }


    // constructor 2
    public Patient(String name,String userName,String password,int age) {
        super(name,userName,password,age);

    }






    // get Doctor id
    public int getDoctor_id() {
        return this.Doctor_id;
    }


    // info
    @Override
    public String toString() {
        return "Patient{" +"name= "+name+" "+",id= "+id+" "+" "+",userName= "+userName+" "+",password= "+password+" "+",age= "+age;
    }
}
