/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu;

import bd.ac.seu.model.Course;
import bd.ac.seu.model.Student;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class MergeCourse {
    private ArrayList<Course>initial;
    private ArrayList<Course>merged;
    private int flag[];

    public MergeCourse() {
        initial = InputReaderSingleton.getCourses();
        flag = new int[250];
        merged = new ArrayList<>();
        Merging();
    }
    
    private void Merging(){
        int ind = 0;
        for(Course c:initial){
            int pos = 0;
            if(flag[ind]==0){
                flag[ind] = 1;
                for(Course cr:initial){
                    if(flag[pos]==0){
                        String corg = c.getCourseCode();
                        String ccomp1 = cr.getCourseCode();
                        String ccomp2 = null;
                        if(cr.getAlternateCourse()!=null){
                          ccomp2 = cr.getAlternateCourse().getCourseCode();
                        }
                        String fac1 = c.getCourseTeacher().getInitials();
                        String fac2 = cr.getCourseTeacher().getInitials();
                        if(corg.compareTo(ccomp1)==0&&fac1.compareTo(fac2)==0){
                            addall(c,cr.getRegisteredStudents());
                            flag[pos] = 1;
                        }
                        else if(cr.getAlternateCourse()!=null){
                            if(corg.compareTo(ccomp2)==0&&fac1.compareTo(fac2)==0){
                                addall(c,cr.getRegisteredStudents());
                                flag[pos] = 1;
                            }
                        }

                    }
                    pos++;  
                }

                merged.add(c);
                
            }
            ind++;
        }
    }
    
    private void addall(Course c,ArrayList<Student>stud){
        for(Student st:stud){
            c.addStudent(st);
        }
    }
    
    public ArrayList<Course> getMerged() {
        return merged;
    }
}
