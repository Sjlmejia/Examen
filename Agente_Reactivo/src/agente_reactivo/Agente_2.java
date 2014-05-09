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
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.lang.acl.ACLMessage;
import java.util.concurrent.CyclicBarrier;
import javax.swing.JOptionPane;
public class Agente_2 extends Agent {

    @Override
    protected void setup() {
       Comportamiento1 c1=new Comportamiento1();
       c1.setAgent(this);
       addBehaviour(c1);
    }

    @Override
    protected void takeDown() {
               super.takeDown(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("BYE");
    }
    
}
