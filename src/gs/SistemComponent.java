/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author omerv
 */
public class SistemComponent {
    JButton btnBaglan;
    JTextField txtPort;
    JTextArea txtOlaylar;
    JLabel lblResim;
    

    public JButton getBtnBaglan() {
        return btnBaglan;
    }

    public void setBtnBaglan(JButton btnBaglan) {
        this.btnBaglan = btnBaglan;
    }

    public JTextField getTxtPort() {
        return txtPort;
    }

    public void setTxtPort(JTextField txtPort) {
        this.txtPort = txtPort;
    }

    public JTextArea getTxtOlaylar() {
        return txtOlaylar;
    }

    public void setTxtOlaylar(JTextArea txtOlaylar) {
        this.txtOlaylar = txtOlaylar;
    }

    

    public JLabel getLblResim() {
        return lblResim;
    }

    public void setLblResim(JLabel lblResim) {
        this.lblResim = lblResim;
    }

    
    
}
