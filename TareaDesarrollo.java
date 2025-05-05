import java.util.Date;

public class TareaDesarrollo extends Tarea {
    private String lenguaje;

    public TareaDesarrollo(String id, String titulo, String descripcion, String lenguaje, Empleado empleado,String responsable, Date fechaInicio, Date fechaFin){
        super(id, titulo, descripcion, responsable, fechaInicio, fechaFin);
        this.lenguaje = lenguaje;
    }

    @Override
    public void ejecutar(){
        System.out.println("Iniciando tarea de desarollo...");
        System.out.println("Desarrollando en " + lenguaje + ":" + titulo);
        System.out.println("Ejecutando pruebas unitarias..");
        System.out.println("Tarea de desarrollo completada con exito");
    }

}
