/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agente_reactivo;

/**
 *
 * @author jorge
 */
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;


/**
 *
 * @author jorge
 */
public class Contenedor {
    AgentController agenteController;
    AgentContainer mainContainer;
    public void contenedor(){
    //acceso a la instancia  JADE runtime
        jade.core.Runtime runtime=jade.core.Runtime.instance();
        //Salimos del JVMsi no hay mas contenedores alrededor
        runtime.setCloseVM(true);
        System.out.println("Runtime ha sido creado\n");      
        //creamos el perfil por defecto en el puerto especificado
        Profile profile=new ProfileImpl(null,1099,null);
        System.out.println("perfil por defecto creado\n");
        //Se arrrranca el contenedor principal
        System.out.println("Inniciando el contenedor principal: "+profile.toString());
        mainContainer = runtime.createMainContainer(profile);
        System.out.println("Contenedor creado");
    }
    public void iniciaragentes(){
        System.out.println("Inciando los agentes...");
        try{
//            agenteController=mainContainer.createNewAgent("Agente1",Agente1.class.getName(),null );
//            agenteController.start();
//            agenteController=mainContainer.createNewAgent("Agente_secuencial",Agente_Secuencial.class.getName(),null );
//        agenteController.start();
        agenteController=mainContainer.createNewAgent("Agente_Reactivo",Agente_Reactivo.class.getName(),null );
        agenteController.start();
               agenteController=mainContainer.createNewAgent("Agente_2",Agente_2.class.getName(),null );
        agenteController.start();
                       agenteController=mainContainer.createNewAgent("Agente_3",Agente_3.class.getName(),null );
        agenteController.start();
//        agenteController=mainContainer.createNewAgent("Agente0",Agente0.class.getName(),null );
//        agenteController.start();
        }catch(StaleProxyException e){
          System.out.println("Error en el main"+e.getLocalizedMessage());

        }
    }
    public static void main(String[] args) {
        Contenedor cont = new Contenedor();
        cont.contenedor();
        cont.iniciaragentes();

    }
}
