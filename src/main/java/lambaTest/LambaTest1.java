package lambaTest;


import java.util.*;

/**
 * Created by pramodvadiraj on 24/03/17.
 */
public class LambaTest1 {


    public static void main(String[] args) {

        //type inference
//        LambaTest lambaTest = s-> System.out.println("Lamba Test ,String Length :" + s.length());
//        lambaTest.foo("Test");

        List<Person> persons = Arrays.asList(new Person("pramod","vadiraj"),new Person("abc","def"),new Person("mno","pqr"),new Person("ghi","jkl"));
        //sort persons based on lname using comparator
        System.out.println("Sorting based on last name:");
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLname().compareTo(o2.getLname());
            }
        });
        System.out.println(persons);

        //displaying names that begins with a and p
        System.out.println("\n\nDisplaying names that begins with an a or p");
        for(Person person : persons)
        {
            if(person.getFname().startsWith("a") || person.getFname().startsWith("p"))
                System.out.println(person);

        }

        //___LAMBDA USAGE____
        //doing the above 2 tasks using lambda functions
        System.out.println("\nReintialising persons and sorting based on firstNames and displaying the names that begin with an a or a c using lambda function:");
        persons = Arrays.asList(new Person("a","b"),new Person("e","f"),new Person("c","d"),new Person("x","y"));
        //defining function and passing the definition as a comparator value
        Collections.sort(persons, (p1, p2) -> p1.getFname().compareTo(p2.getFname()));
        System.out.println(persons);
        //implementing the interface test and assiging that to a variable test
        Condition test = t->t.startsWith("a")||t.startsWith("c");
        for(Person person : persons)
        {
            if(test.condition(person.getFname()))
                System.out.print(person);

        }


    }

}
@FunctionalInterface
interface Condition
{
    boolean condition(String inp);
     default void randomDefaultMethodWithImplementation_WhichIsChill()
    {
        System.out.println("asd");
    }

}

class Person
{
    String fname;
    String lname;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return  "lname='" + lname ;

    }
}
