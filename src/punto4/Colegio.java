package punto4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Colegio {
    private final ArrayList<Alumno>alumnos;
    public Colegio(){alumnos=new ArrayList<>();}
    public void agregarAlumno(Alumno alumno){
       try {
           alumnos.add(alumno);
       }catch (RuntimeException e){
           System.out.println("no se pudo guardar al alumno, error: "+e.getMessage());
       }
    }
    public HashMap<String,Long> cantAlumnosPorNacionalidad(){
        try {
            return(HashMap<String, Long>)alumnos.stream().collect(Collectors.groupingBy(Alumno::nacionalidad,Collectors.counting()));
        }catch (RuntimeException e){
            System.out.println("No se pudieron conseguir la cantidad de alumnos para cada nacionalidad. Error: "+e.getMessage());
        }
        return new HashMap<>();
    }
    public Integer cantNacionalidades(){
        try {
            return  alumnos.stream().map(Alumno::nacionalidad).collect(Collectors.toSet()).size();
        }catch (RuntimeException e){
            System.out.println("No se pudieron conseguir la cantidad de nacionalidades. Error: "+e.getMessage());
        }
        return 0;
    }
   private void borrarAlumnoExcepcion(Alumno alumno){//ANOTAR
        if(!alumnos.contains(alumno))throw new RuntimeException("El alumno no se encontro");
        else alumnos.remove(alumno);
   }
   public void borrarAlumno(Alumno alumno){
        try {
            borrarAlumnoExcepcion(alumno);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
   }
   public void mostrar(){
        try{
            System.out.println("Alumnos: "+alumnos);
            System.out.println("Cantidad de alumnos por nacionalidad: "+cantAlumnosPorNacionalidad());
            System.out.println("Cantidad de nacionalidadaes: "+cantNacionalidades());
        }catch (RuntimeException e){
            System.out.println("Error al mostrar los datos. Error: "+e.getMessage());
        }
   }
}
