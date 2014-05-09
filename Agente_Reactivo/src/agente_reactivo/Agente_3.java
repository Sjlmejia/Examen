/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agente_reactivo;

/**
 *
 * @author jorge
 */
import comportamientos.Comportamiento1;
import comportamientos.Comportamiento2;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.lang.acl.ACLMessage;
import java.util.concurrent.CyclicBarrier;
import javax.swing.JOptionPane;
public class Agente_3 extends Agent {

    @Override
    protected void setup() {
 Comportamiento2 c2=new Comportamiento2();
       c2.setAgent(this);
       addBehaviour(c2);
    }

    @Override
    protected void takeDown() {
                super.takeDown(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("BYE");
    }
    
}
