
import java.io.Serializable;

public class User implements Serializable{
    
    String name;
    String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public void sayHello(){
        System.out.println("Hello " + name); 
    }
}
