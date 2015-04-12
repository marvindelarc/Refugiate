
import COM.clsGestorBajaEmpresaPersona;
import COM.clsGestorComentarios;
import COM.clsGestorCatalogo;
import Entidades.clsTipoHabitacion;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//        clsTipoHabitacion entidad = new clsTipoHabitacion();
//        entidad.setNombreComercial("Simple");
//        System.out.print(clsGestorCatalogo.insertarTipoHabitacion(entidad));
//        System.out.print(clsGestorCatalogo.ListarTipoHabitacion(true).size());
//        System.out.print(clsGestorComentarios.ListarComentario(true));
        System.out.print(clsGestorBajaEmpresaPersona.ListarBajaEmpresaPersonas(true));
    }
    
}
