package comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Student stu1 = new Student("A",20,27);
        Student stu2 = new Student("B",21,23);
        Student stu3 = new Student("c",19,23);
        Student stu4 = new Student("d",19,20);
        Student stu5 = new Student("e",18,18);
        Student stu6 = new Student("f",18,16);


        List<Student> studentList = new ArrayList<>();
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);
        studentList.add(stu4);
        studentList.add(stu5);
        studentList.add(stu6);
        studentList.sort(new AgeShengOrder());
        for (Student student : studentList){
            System.out.println(student.name+" "+student.high+" "+student.age);
        }
        System.out.println("========================================");

        TreeMap<Student ,String> treeMap = new TreeMap<>(new HighShengAgeShengOrder());
        treeMap.put(stu1,"AA");
        treeMap.put(stu2,"BB");
        treeMap.put(stu3,"CC");
        treeMap.put(stu4,"DD");
        treeMap.put(stu5,"EE");
        treeMap.put(stu6,"FF");

        for (Student student:treeMap.keySet()){
            System.out.println(student.name+" "+student.high+" "+student.age);
        }

        System.out.println("========================================");
        TreeMap<Student ,String> treeMap1 = new TreeMap<>( (a,b) -> a.age!=b.age?a.age - b.age:a.high-b.high );
        treeMap1.put(stu1,"AA");
        treeMap1.put(stu2,"BB");
        treeMap1.put(stu3,"CC");
        treeMap1.put(stu4,"DD");
        treeMap1.put(stu5,"EE");
        treeMap1.put(stu6,"FF");
        for (Student student:treeMap1.keySet()){
            System.out.println(student.name+" "+student.high+" "+student.age);
        }

    }
}
