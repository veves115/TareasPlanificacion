import java.util.Date;

public class TareaDiseño extends Tarea{
    private String herramienta;

    public TareaDiseño(String id, String titulo, String descripcion, Empleado empleado, String responsable, Date fechaInicio, Date fechaFin, String herramienta){
        super(id, titulo, descripcion, responsable, fechaInicio, fechaFin);
        this.herramienta = herramienta;

    }

    @Override
    public void ejecutar(){
        System.out.println("Diseñando en " + herramienta + ":" + titulo);
    }
}
