
package Entities;


public class Student {
    
    private int id;
    private String name;
    private String cpf;
    private String email;
    private int registration;
    private String login;
    private String password;

    public Student () {
        
    }
    
    public Student (String name, String email, String login, String password, String cpf, int registration) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.cpf = cpf;
        this.registration = registration;
    }
    
    
    public String GetName (){
    return this.name;
}
    public void SetName(String name) {
        this.name = name;
    }
    
        public String GetEmail (){
    return this.email;
}
        
    public void SetEmail(String email) {
        this.email = email;
    }
    
        public String GetLogin (){
    return this.login;
}
        
    public void SetLogin(String login) {
        this.login = login;
    }
    
        public String GetPassword (){
    return this.password;
}
        
    public void SetPassword(String senha) {
        this.password = senha;
    }
    
        public String GetCpf (){
    return this.cpf;
}
        
    public void SetCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public int GetRegistration (){
    return this.registration;
}
        
    public void SetRegistration(int registration) {
        this.registration = registration;
    }
    
        public int GetId (){
    return this.registration;
}
        
    public void SetId(int id) {
        this.id = id;
    }
    
}
