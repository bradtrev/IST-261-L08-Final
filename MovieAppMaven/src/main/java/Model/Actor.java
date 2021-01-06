
package Model;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Actor implements Serializable {
    private String uuid;
    private String firstName;
    private String lastName;
    private Integer age;
//    private Image actorImage;
//    private ArrayList<Movie> filmography;

    public Actor(String uuidIn, String fNameIn, String lNameIn, Integer ageIn /*, Image actorImageIn,*/ /*ArrayList<Movie> filmographyIn*/) {
        uuid = uuidIn;
        firstName = fNameIn;
        lastName = lNameIn;
        age = ageIn;
//        actorImage = actorImageIn;
//        filmography = filmographyIn;
    }

    @Override
    public String toString() {
         return String.format(
            "UUID: %s\n" +
            "firstName: %s\n" +
            "lastName: %s\n" +
            "age: %d",
            this.uuid,
            this.firstName,
            this.lastName,
            this.age
         );
    }

    public ArrayList<String> getAttributes() {
        ArrayList<String> attributes = new ArrayList<String>();
        for(int i = 1; i < 4; i++){
            attributes.add(getAttribute(i));
        }

        return attributes;
    }

    public ArrayList<String> getAllAttributes() {
        ArrayList<String> attributes = new ArrayList<String>();
        for(int i = 0; i < 4; i++){
            attributes.add(getAttribute(i));
        }

        return attributes;
    }

    public String getAttribute(int n) {

        switch (n) {
            case 0:
                return getUuid();
            case 1:
                return getFirstName();
            case 2:
                return getLastName();
            case 3:
                return getAge().toString();
            default:
                return "getAttribute error";
        }
    }

    public String getActorString(Actor actorTemp){
        return actorTemp.getFirstName() + " " + actorTemp.getLastName() + " (" + actorTemp.getAge() + ")";
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public Image getActorImage() {
//        return actorImage;
//    }
//
//    public void setActorImage(Image actorImage) {
//        this.actorImage = actorImage;
//    }

//    public ArrayList<Movie> getFilmography() {
//        return filmography;
//    }

//    public void setFilmography(ArrayList<Movie> filmography) {
//        this.filmography = filmography;
//    }
    
}
