import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
        Empleado emp1 = new Empleado("Pablo Ares","E001","Desarrollador Junior","pabloares@gmail.com");
        Empleado emp2 = new Empleado("Brenda Franco","E002","Desarrollador Junior","brendafranco@gmail.com");
        Empleado emp3 = new Empleado("Berto Labin","E003","Desarrollador Senior","bertolabin@gmail.com");

        //Fechas para las tareas
        Date hoy = new Date();
        Date inicio1 = sdf.parse("10/05/2025");
        Date fin1 = sdf.parse("20/05/2025");
        Date inicio2 = sdf.parse("15/05/2025");
        Date fin2 = sdf.parse("25/05/2025");
        Date inicio3 = sdf.parse("30/05/2025");
        Date fin3 = sdf.parse("10/06/2025");

        //Crear recursos multimedia
        RecursoMultimedia recurso1 = new RecursoMultimedia("R001","Diagrama UML","PNG","/recursos/diagrama.png",new Date());
        RecursoMultimedia recurso2 = new RecursoMultimedia("R002","Manual de usuario","PDF","/recursos/manual.pdf",new Date());

        //Crear tareas
            TareaDesarrollo tarea1 = new TareaDesarrollo("T001","Login","Desarrollar sistema de autenticación","Java",emp1,emp1.getNombre(),inicio1,fin1);
            TareaDesarrollo tarea2 = new TareaDesarrollo("T002","Pruebas de integración","Realizar pruebas de integración del móddulo de login","Java",emp2,emp2.getNombre(),inicio2,fin2);

        //Agregar recursos a las tareas
            tarea1.agregarRecurso(recurso1);
            tarea2.agregarRecurso(recurso2);

        //Crear planificador y agregar tareas
            Planificador planificador = new Planificador();
            planificador.agregarTarea(tarea1);
            planificador.agregarTarea(tarea2);

        //Mostrar todas las tareas
            System.out.println("=== TODAS LAS TAREAS ===");
            for (Tarea t : planificador.getTodasLasTareas()){
                System.out.println(t.getResumen());
                System.out.println("-----------------");
            }
        //Cambiar estado de una tarea
        tarea1.cambiarEstado(EstadoTarea.EN_CURSO);

            //Buscar tareas por estado
            System.out.println("=== TAREAS EN CURSO ===");
            List<Tarea> tareasEnCurso = planificador.buscarPorEstado(EstadoTarea.EN_CURSO);
            for (Tarea t : tareasEnCurso){
                System.out.println(t.getResumen());
                System.out.println("-----------------");
                
            }


        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

