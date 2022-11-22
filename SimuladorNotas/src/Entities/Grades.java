
package Entities;


public class Grades {

        
    private int idStudent;
    private int idMatter;
    private float noteAc1;
    private float ac1Multiplier;
    private float noteAc2;
    private float ac2Multiplier;
    private float noteAf;
    private float afMultiplier;
    private float noteSub;
    private float subMultiplier;
    private float noteAg;
    private float agMultiplier;
    
    public Grades () {
        
    }
    
    public Grades(int idStudent, int idMatter, String teacher) {
        this.idStudent = idStudent;
        this.idMatter = idMatter;
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
    
    public float getNoteAc1() {
        return noteAc1;
    }

    public void setNoteAc1(float noteAc1) {
        this.noteAc1 = noteAc1;
    }

    public float getAc1Multiplier() {
        return ac1Multiplier;
    }

    public void setAc1Multiplier(float ac1Multiplier) {
        this.ac1Multiplier = ac1Multiplier;
    }

    public float getNoteAc2() {
        return noteAc2;
    }

    public void setNoteAc2(float noteAc2) {
        this.noteAc2 = noteAc2;
    }

    public float getAc2Multiplier() {
        return ac2Multiplier;
    }

    public void setAc2Multiplier(float ac2Multiplier) {
        this.ac2Multiplier = ac2Multiplier;
    }

    public float getNoteAf() {
        return noteAf;
    }

    public void setNoteAf(float noteAf) {
        this.noteAf = noteAf;
    }

    public float getAfMultiplier() {
        return afMultiplier;
    }

    public void setAfMultiplier(float afMultiplier) {
        this.afMultiplier = afMultiplier;
    }

    public float getNoteSub() {
        return noteSub;
    }

    public void setNoteSub(float noteSub) {
        this.noteSub = noteSub;
    }

    public float getSubMultiplier() {
        return subMultiplier;
    }

    public void setSubMultiplier(float subMultiplier) {
        this.subMultiplier = subMultiplier;
    }

    public float getNoteAg() {
        return noteAg;
    }

    public void setNoteAg(float noteAg) {
        this.noteAg = noteAg;
    }

    public float getAgMultiplier() {
        return agMultiplier;
    }

    public void setAgMultiplier(float agMultiplier) {
        this.agMultiplier = agMultiplier;
    }
    
}
