public class Empleado{
    private String nombre;
    private String id;
    private String puesto;
    private String email;

    public Empleado(String nombre, String id, String puesto, String email){
        this.nombre = nombre;
        this.id = id;
        this.puesto = puesto;
        this.email = email;
    }
    public String getNombre(){
        return nombre;
    }

    public String getId(){
        return id;
    }

    public String getPuesto(){
        return puesto;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return nombre + " " + id + " " + puesto + " " + email + "\n";
    }

}
