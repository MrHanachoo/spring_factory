package spring.boot.batch;

/**
 * Created by mhan on 5/12/16.
 */
public class Human {

    private String firstName;
    private String lastName;

    public Human() {
    }

    public Human(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return "first_name: "+firstName+" ,last_name: "+lastName;
    }
}
