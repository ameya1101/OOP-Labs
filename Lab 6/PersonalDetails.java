public class PersonalDetails {
    public String name;
    public String address;

    public PersonalDetails(String name, String address){
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return ("Name: " + this.name + "\n"
            +  "Address: " + this.address); 
    }
}