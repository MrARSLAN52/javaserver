/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroller;

import gs.SistemComponent;
import gs.Veri;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import server.Server;

/**
 *
 * @author omerv
 */
public class baglantiKontrol {
    SistemComponent sistem;
    ServerSocket server;

    public baglantiKontrol() {
        
    }
    
    public void tikla(SistemComponent comp) throws IOException{
        sistem = comp;
        baglantiDurum();
        
    }
   
    void olayYukle(String olay)
    {
        String olayGunluk = sistem.getTxtOlaylar().getText();
        sistem.getTxtOlaylar().selectAll();        
        sistem.getTxtOlaylar().replaceSelection("");
        sistem.getTxtOlaylar().append(olay + "\n" + olayGunluk);
    }
    
    ObjectInputStream in;  

    boolean aktif = false;
    Thread thread;
    int port;
    private void baglantiDurum() throws IOException{
        
        if(sistem.getBtnBaglan().getText().equals("Çalışıyor"))
        {
            aktif = false;
            thread.stop();
            server.close();
            sistem.getBtnBaglan().setText("Başlat");
            olayYukle("Sunucu durduruldu");
        }
        else
        {
            
            port = portYazilisKontrol.kontrolEt(sistem.getTxtPort().getText());
            if(port == -1)
                olayYukle("Port numarası sadece sayı olabilir.");
            else if(port == -2)
                olayYukle("Port numarası 1024 ile 65535 arasında olabilir");
            else
            {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress("localhost", port), 1000);
                    socket.close();
                    olayYukle("Bu port başka bir yazılım tarafından kullanılıyor");
            
                } catch (IOException ex) {
                    aktif = true;
                    new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InetAddress adres = InetAddress.getLocalHost();
                            server = new ServerSocket(port);
                            sistem.getBtnBaglan().setText("Çalışıyor");
                            olayYukle(adres.getHostAddress() + ":"+port+" adresi dinleniyor");

                            Socket gelen = server.accept();
                            in = new ObjectInputStream(gelen.getInputStream());
                            Veri data = (Veri) in.readObject();
                            String name = data.getName();
                            olayYukle(gelen.getInetAddress().getHostAddress()+":"+gelen.getPort() + " adresinden bağlantı sağlandı");
                             while (true) {
                                data = (Veri) in.readObject();
                                olayYukle("Dosya Alındı");
                                ImageIcon icon = new ImageIcon(data.getFile());
                                sistem.getLblResim().setIcon(icon);
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                    }
                }).start();
                }
                
            }
        }
            
    }
}
