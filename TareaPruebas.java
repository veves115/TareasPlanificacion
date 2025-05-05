import java.util.Date;

public class TareaPruebas extends Tarea{
    private String tipoPrueba;

    public TareaPruebas(String id, String titulo, String descripcion, String responsable, Date fechaInicio, Date fechaFin, String tipoPrueba){
        super(id, titulo, descripcion, responsable, fechaFin, fechaInicio);
        this.tipoPrueba = tipoPrueba;
    }

    @Override
    public void ejecutar(){
        System.out.println("Ejecutando pruebas " + tipoPrueba + ":" +  titulo);
    }
}
