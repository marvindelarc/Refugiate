import COM.clsGestor;
import DAO.clsCostoTipoHabitacionDAO;
import Entidades.*;
import java.time.Instant;
import java.util.Date;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Long a =new Date().getTime();
//        System.out.println(clsGestor.ListarEmpresaServicio(a).size());
//        System.out.println(clsGestor.listarServicioSucursal(a).size());
//        System.out.println(clsGestor.ListarIntalacionServicio(a).size());
            System.out.println(clsGestor.ListarCostoTipoHabitacionServicio(a).size());
//        System.out.println(clsGestor.actualizarWebAdmin(entidadWA));
//    
    }    
}