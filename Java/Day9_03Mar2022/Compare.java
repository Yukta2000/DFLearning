import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
   private Integer marks;
   private Integer rollno;
   private String name;

    Student(Integer marks,Integer rollno,String name){
        this.marks=marks;
        this.rollno=rollno;
        this.name=name;
    }

    public Integer getMarks(){
        return this.marks;
    }

    public Integer getRollno(){
        return this.rollno;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
       
        return "Marks: "+this.marks+ " , RollNo: "+this.rollno + " , Name:" + this.name;
    }


}

class StudentMarksCompare implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        
        return o1.getMarks().compareTo(o2.getMarks());
    }

}

class StudentRollnoCompare implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        
        return o1.getRollno().compareTo(o2.getRollno());
    }
    
}


public class Compare {
    public static void main(String[] args){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(40,50, "Alice"));
        students.add(new Student(30,3,"Maria"));
        students.add(new Student(45,20,"Jason"));
        students.add(new Student(60,1,"Menon"));
        students.add(new Student(80, 25,"Mili"));

        Collections.sort(students,new StudentMarksCompare());
        System.out.println("Sort By Marks");
        for(int i=0;i< students.size();i++){
            System.out.println(students.get(i));
        }

        Collections.sort(students,new StudentRollnoCompare());
        System.out.println("Sort By RollNo ");
        for(int i=0;i< students.size();i++){
            System.out.println(students.get(i));
        }
    }
}
