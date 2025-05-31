
import java.io.Serializable;

public class User implements Serializable{
    
    String name;
    String password;

    public void sayHello(){
        System.out.println("Hello account " + name); 
    }

    public String getName(){ return name; }
    public String getPassword() { return password; }
}
