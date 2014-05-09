/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comportamientos;

/**
 *
 * @author jorge
 */
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
public class Comportamiento2 extends SimpleBehaviour  {

  boolean  fin=false;
    @Override
    public void setAgent(Agent a) {
        super.setAgent(a); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void action() {
              System.out.println("Este es mi comportamiento 2");

        ACLMessage msj = myAgent.blockingReceive();
        if (msj != null) {
            System.out.println("Recibi: " + msj.getSender().getLocalName() + ": " + msj.getContent());
            // Envia constestación
           Integer a=Integer.parseInt(msj.getContent());
            String respuesta;
            if (a>5) {
                respuesta = "Daño severo";
            } else {
                respuesta = "Daño moderado";
            }
            System.out.println(getAgent().getLocalName() + ": Enviando respuesta");
            ACLMessage aclrespuesta = new ACLMessage(ACLMessage.INFORM);
            aclrespuesta.setContent(respuesta);
            aclrespuesta.addReceiver(msj.getSender());
            getAgent().send(aclrespuesta);
            
        } else {
            block();
        }
      
        
    }

    @Override
    public boolean done() {
         System.out.println("He terminado mi comportamiento 2"); //To change body of generated methods, choose Tools | Templates.
        return fin;
    }
    
}
