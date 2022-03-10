import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

class Student{
    private String name;
    private Integer classRoom;
   
    Student(String name,Integer classRoom ){
        this.name=name;
        this.classRoom = classRoom;
    }

    public String getName(){
       return this.name;
    }

    public Integer getClassRoom(){
        return this.classRoom;
    }

    @Override
    public String toString() {
        return this.getName();
        //return "Name: "+this.getName() + " , ClassRoom: "+this.getClassRoom();
    }
}


public class NestedCollection
{
	public static void main(String[] args) {
	    Map<Integer,List<Student>> studentClass = new HashMap<>();
	    Random rand = new Random();
        for(int i=1;i<=100;i++){
            Integer num = 1 + rand.nextInt(10);
            Student student = new Student("Student"+i,num);
            //List<Student> studentList = new ArrayList<>(){{ add(student); }};
            List<Student> studentList = new ArrayList<>(Arrays.asList(student));
            //List<Student> studentList = new ArrayList<>();
            //studentList.add(student);
            
            if(studentClass.containsKey(num)){
                studentList.addAll(studentClass.get(num));
                studentClass.put(num,studentList);
            }
            else{
                studentClass.put(num,studentList);
            }
        }
        
        for(Integer classRoom : studentClass.keySet()){
            System.out.println("ClassRoom: "+classRoom + studentClass.get(classRoom));
            System.out.println("#####################################################");
        }
	}
}
