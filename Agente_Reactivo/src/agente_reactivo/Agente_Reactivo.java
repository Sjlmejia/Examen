/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agente_reactivo;

/**
 *
 * @author jorge
 */
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.gui.GuiAgent;
import jade.lang.acl.ACLMessage;
import java.util.concurrent.CyclicBarrier;
import javax.swing.JOptionPane;
import jade.core.behaviours.SequentialBehaviour;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class Agente_Reactivo extends Agent {

    /**
     * @param args the command line arguments
     */
    
    
    
        public Agente_Reactivo() {
            try {
                UIManager.setLookAndFeel(("com.nilo.plaf.nimrod.NimRODLookAndFeel"));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Agente_Reactivo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Agente_Reactivo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Agente_Reactivo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Agente_Reactivo.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
    
    
    @Override
    protected void setup() {
        
         SequentialBehaviour conteo_inicio = new SequentialBehaviour(this);
         conteo_inicio.addSubBehaviour(new OneShotBehaviour(this){
           @Override   
           public void action(){JOptionPane.showMessageDialog(null, "Inicio en el sistema en  : ");
    
           
           
           }});
          conteo_inicio.addSubBehaviour(new OneShotBehaviour(this){
           @Override   
           public void action(){JOptionPane.showMessageDialog(null, "3!!! ");
    
           
           
           }});
           conteo_inicio.addSubBehaviour(new OneShotBehaviour(this){
           @Override   
           public void action(){JOptionPane.showMessageDialog(null, "2 !!! ");
    
           
           
           }});
            conteo_inicio.addSubBehaviour(new OneShotBehaviour(this){
           @Override   
           public void action(){JOptionPane.showMessageDialog(null, "1 !!! ");
    
           
           
           }});
         conteo_inicio.addSubBehaviour(new Comportamiento(this));
  addBehaviour(conteo_inicio);
    }

    @Override
    protected void takeDown() {
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
    }
  private class Comportamiento extends Behaviour{

        Agent agent;
        boolean fin = false;

        private Comportamiento(Agent agent) {
                   this.agent = agent;
        }
   

        @Override
        public void action() {
    
          try {
                Object entrada = JOptionPane.showInputDialog(null, "Estas siendo golpeado: ");
                ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);
                mensaje.setLanguage("Español");
                AID receptor = new AID("agente_2", AID.ISLOCALNAME);
                mensaje.addReceiver(receptor);

                mensaje.setContent(entrada.toString());

                send(mensaje);

                ACLMessage mensaje2 = blockingReceive();
                if (mensaje2 != null) {
                    JOptionPane.showMessageDialog(null, "Bender dice: " + mensaje2.getContent());
                    fin = true;
                }
                
                if (mensaje2.getContent().equalsIgnoreCase("Si me estan golpenado")){
                try{
                  Object entrada3=JOptionPane.showInputDialog(null, "Que nivel de daño tienes: ");
                  ACLMessage mensaje3= new ACLMessage(ACLMessage.REQUEST);
                  mensaje3.setLanguage("Español");
                  AID receptor3=new AID("agente_3",AID.ISLOCALNAME);
                  mensaje3.addReceiver(receptor3);
                  mensaje3.setContent(entrada3.toString());
                  send(mensaje3);
                  ACLMessage mensaje4=blockingReceive();
                   if (mensaje4 != null) {
                    JOptionPane.showMessageDialog(null, "Bender dice: " + mensaje4.getContent());
//                    fin = true;
                }
                }catch(Exception e){
                    
                }
                }else{
                  JOptionPane.showMessageDialog(null, "Bender dice : vamos a las bielas");  
                }
            } catch (Exception e) {
            }
 
        }

      
        @Override
        public boolean done() {
               System.out.println("Estoy terminando mi: "+ this.getBehaviourName());
       
            return true;
        }
  }

}
