import COM.clsGestor;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//        clsTipoHabitacion entidad = new clsTipoHabitacion();
//        entidad.setNombreComercial("Simple");
//        System.out.print(clsGestor.insertarTipoHabitacion(entidad));
        System.out.print(clsGestor.ListarTipoHabitacion(false).size());
//        System.out.print(clsGestor.ListarComentario(true));
//        System.out.print(clsGestor.ListarBajaEmpresaPersonas(true));
//        System.out.print(clsGestor.ListarBajaEmpresaPersonas(true));
//        System.out.print(clsGestor.ListarDepartamento(true));
//        System.out.print(clsGestor.ListarDetalleReservas(true));
//        System.out.print(clsGestor.listarDistrito(true));
    }    
}