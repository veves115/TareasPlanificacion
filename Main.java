import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date incio2 = sdf.parse("15/05/2025");
        Date fin2 = sdf.parse("25/05/2025");
        Date inicio3 = sdf.parse("30/05/2025");
        Date fin3 = sdf.parse("10/06/2025");

        //Crear recursos multimedia
        RecursoMultimedia recurso1 = new RecursoMultimedia("R001","Diagrama UML","PNG","/recursos/diagrama.png",new Date());
        RecursoMultimedia recurso2 = new RecursoMultimedia()
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
