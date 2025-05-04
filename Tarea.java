import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Tarea {
    protected String id;
    protected String titulo;
    protected String descripcion;
    protected String responsable;
    protected Empleado empleado;
    protected Date fechaInicio;
    protected Date fechaFin;
    protected EstadoTarea estado;
    protected List<RecursoMultimedia> recursosAsociados;

    public Tarea(String id,String titulo,String descripcion, String responsable,Date fechaInicio,Date fechaFin) {
        if(fechaInicio.after(fechaFin)) {
            throw new IllegalArgumentException("ERROR: La fecha de inicio ha de ser mayor a la fecha de fin");
        }
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = EstadoTarea.PENDIENTE;
        this.recursosAsociados = new ArrayList<>();
    }
    public abstract void ejecutar();

    public void cambiarEstado(EstadoTarea nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void agregarRecurso(RecursoMultimedia recurso){
        if(recurso != null){
            recursosAsociados.add(recurso);
        }
    }

    public void actualizarFechas(Date inicio, Date fin){
    if(inicio.after(fin)) {
        throw new IllegalArgumentException("La fecha de inicio ha de ser anterior a la fecha de fin");
    }
    this.fechaInicio = inicio;
    this.fechaFin = fin;
    }

    public String getResumen(){
        return "Tarea ID: " + id + "\n" +
                "Título: " + titulo + "\n" +
                "Responsable: " + getResponsable() + "\n" +
                "Estado: " + estado +"\n" +
                "Fecha de inicio: " + fechaInicio + "\n" +
                "Fecha de fin: " + fechaFin;
    }
    public String getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getResponsable(){
        return responsable;
    }

    public void setResponsable(String responsable){
        this.responsable = responsable;
    }

    public Date getFechaInicio(){
        return fechaInicio;
    }

    public Date getFechaFin(){
        return fechaFin;
    }

    public EstadoTarea getEstado(){
        return estado;
    }
}
