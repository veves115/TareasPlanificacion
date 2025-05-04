import java.util.Date;

public class RecursoMultimedia {
    private String id;
    private String nombre;
    private String tipo;
    private String ruta;
    private long tamaño;
    private Date fechaCreacion;

    public RecursoMultimedia(String id, String nombre, String tipo, String ruta, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.ruta = ruta;
        this.fechaCreacion = new Date();
    }

    public String getInformacion(){
        return "Recurso: " + nombre + "(" + tipo + ")\n" +
                "Ruta: " + ruta + "\n" +
                "Tamaño: " + formatoTamaño(tamaño) + "\n" +
                "Fecha creacion: " + fechaCreacion;
    }

    private String formatoTamaño(long bytes){
        if(bytes < 1024){
            return bytes + "bytes";
        } else if (bytes < 1024 * 1024) {
            return (bytes / 1024) + "KB";
        }else if (bytes < 1024 * 1024 * 1024) {
            return (bytes / (1024 * 1024)) + "MB";
        }else{
            return (bytes / (1024 * 1024 * 1024)) + "GB";
        }
    }
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public long getTamaño(){
        return tamaño;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
}
