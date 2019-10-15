/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroller;

/**
 *
 * @author omerv
 */
public class portYazilisKontrol {
    public static int kontrolEt(String port)
    {
        try
        {
            int ceviri = Integer.valueOf(port);
            if(ceviri < 1025 || ceviri >65535)
                return -2;
            else
                return ceviri;
        }
        catch(Exception e)
        {
            return -1;
        }
       
    }
}
