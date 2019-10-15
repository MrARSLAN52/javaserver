/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author omerv
 */
public class Veri implements Serializable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    
    private byte[] file;
    private String name;
}
