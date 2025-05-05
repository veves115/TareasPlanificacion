import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Planificador {
    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(Tarea nuevaTarea){
        tareas.add(nuevaTarea);
    }
    public void eliminarTarea(String idTarea){
        tareas.removeIf(t -> t.getId().equals(idTarea));
    }

    public List<Tarea> buscarPorEstado(EstadoTarea estado){
        return tareas.stream().filter(t -> t.getEstado() == estado)
                .collect(Collectors.toList());
    }

    public List<Tarea> buscarPorResponsable(Empleado responsable){
        return  tareas.stream().filter(r -> r.getResponsable().equals(responsable))
                .collect(Collectors.toList());
    }

    public List<Tarea> obtenerTareasPorFecha(Date fecha){
        return tareas.stream().filter(f -> !fecha.before(f.getFechaInicio()) && !fecha.after(f.getFechaFin()))
                .collect(Collectors.toList());
    }

    public List<Tarea> listarProximasTareas(){
        Calendar calendario = Calendar.getInstance();
        Date hoy = calendario.getTime();
        calendario.add(Calendar.DAY_OF_YEAR, 7);
        Date siete_Dias = calendario.getTime();

        return tareas.stream()
                .filter(d -> d.getFechaInicio().after(hoy) && d.getFechaInicio().before(siete_Dias))
                .collect(Collectors.toList());
    }
    public String generarInformeAvance(){
        long tareas_totales = tareas.size();
        long tareas_completadas = tareas.stream()
                .filter(e -> e.getEstado() == EstadoTarea.FINALIZADA).count();

        double porcentaje = tareas_totales == 0 ? 0: ((double) tareas_completadas/tareas_totales)*100;
        return "Informe de avance de tareas: " + tareas_completadas + "/" + tareas_totales + " completadas( " + String.format("%.2f", porcentaje) + "%";
    }
    public List<Tarea> getTodasLasTareas(){
        return tareas;
    }
}
