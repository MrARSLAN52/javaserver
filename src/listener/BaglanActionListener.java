/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import gs.SistemComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import kontroller.baglantiKontrol;

/**
 *
 * @author omerv
 */
public class BaglanActionListener implements ActionListener{

    baglantiKontrol kntrol;
    SistemComponent comp;
    public BaglanActionListener(SistemComponent sistem) {
        kntrol = new baglantiKontrol();
        comp = sistem;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            kntrol.tikla(comp);
        } catch (IOException ex) {
            Logger.getLogger(BaglanActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
