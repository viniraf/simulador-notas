
package Entities;


public class Grades {
    
    private int idStudent;
    private int idMatter;
    private String teacher;
    
    public Grades () {
        
    }
    
    public Grades(int idStudent, int idMatter, String teacher) {
        this.idStudent = idStudent;
        this.idMatter = idMatter;
        this.teacher = teacher;
    }
    
    
    public int GetIdStudent (){
        return this.idStudent;
}
    public void SetIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
    
    public int GetIdMatter (){
        return this.idMatter;
}
        
    public void SetIdMatter(int idMatter) {
        this.idMatter = idMatter;
    }
    
        public String GetTeacher (){
    return this.teacher;
}
        
    public void SetTeacher(String teacher) {
        this.teacher = teacher;
    }

}
