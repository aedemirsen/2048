/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Aedamantium
 */
public class Methods_2048 {
    
    void yukari(JLabel[][] label,ArrayList<JPanel> panelList,ArrayList<JLabel> labelList){
        boolean sabit = true;
        JLabel tut = null;        
        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label[i].length; j++) {                
                if (!label[i][j].getText().equals("")) {
                    String temp = label[i][j].getText();
                    int hold = i;
                    for (int k = i-1; 0 <= k; k--) {                        
                        if (label[k][j].getText().equals("")) {
                            label[k][j].setText(temp); 
                            hold--;
                            label[k+1][j].setText("");  
                            sabit = false;
                        }
                        else if (label[k][j].getText().equals(temp) && k == hold-1 && label[k][j] != tut) {
                            int sonuc = Integer.parseInt(label[k][j].getText())+Integer.parseInt(temp);
                            label[k][j].setText(sonuc+"");
                            int puan = Integer.parseInt(_2048.puan.getText());
                            _2048.puan.setText(puan+sonuc+"");
                            tut = label[k][j];
                            label[k+1][j].setText("");
                            sabit = false;
                        }
                    }
                }
            }
        }
        if (!sabit) {
            Timer t = new Timer(200, new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e) {
                    birSayiUret(labelList);
                    renkleriBelirle(panelList, labelList);
                }}); 
                  t.setRepeats(false);        
                  t.start();
        }
        
        renkleriBelirle(panelList, labelList);
    }
    
    void asagi(JLabel[][] label,ArrayList<JPanel> panelList,ArrayList<JLabel> labelList){
        boolean sabit = true;   
        JLabel tut = null;
        for (int i = label.length-1; i >= 0 ; i--) {
            for (int j = label[i].length-1; j >= 0; j--) {
                if (!label[i][j].getText().equals("")) {
                    String temp = label[i][j].getText();
                    int hold = i;
                    for (int k = i+1; label.length > k; k++) {                        
                        if (label[k][j].getText().equals("")) {                            
                            label[k][j].setText(temp); 
                            hold++;
                            label[k-1][j].setText(""); 
                            sabit = false;
                        }
                        else if (label[k][j].getText().equals(temp) && k == hold+1 && label[k][j] != tut) {
                            int sonuc = Integer.parseInt(label[k][j].getText())+Integer.parseInt(temp);
                            label[k][j].setText(sonuc+"");
                            int puan = Integer.parseInt(_2048.puan.getText());
                            _2048.puan.setText(puan+sonuc+"");
                            tut = label[k][j];
                            label[k-1][j].setText("");
                            sabit = false;
                        }
                    }
                }
            }
        }
        if (!sabit) {
            Timer t = new Timer(200, new ActionListener() {         
                 @Override
                 public void actionPerformed(ActionEvent e) {
                  birSayiUret(labelList);
                  renkleriBelirle(panelList, labelList);
                 }}); 
                 t.setRepeats(false);        
                 t.start();
        }        
        renkleriBelirle(panelList, labelList);
    }
    
    void saga(JLabel[][] label,ArrayList<JPanel> panelList,ArrayList<JLabel> labelList){
        boolean sabit = true;
        JLabel tut = null;
        for (int i = label[0].length-1; i >= 0 ; i--) {
            for (int j = label.length-1; j >= 0; j--) {
                if (!label[i][j].getText().equals("")) {
                    String temp = label[i][j].getText();
                    int hold = j;
                    for (int k = j+1; label.length > k; k++) {
                        if (label[i][k].getText().equals("")) {
                            label[i][k].setText(temp); 
                            hold++;
                            label[i][k-1].setText("");  
                            sabit = false;
                        }
                        else if (label[i][k].getText().equals(temp) && k == hold+1 && label[i][k] != tut) {
                            int sonuc = Integer.parseInt(label[i][k].getText())+Integer.parseInt(temp);
                            label[i][k].setText(sonuc+"");
                            int puan = Integer.parseInt(_2048.puan.getText());
                            _2048.puan.setText(puan+sonuc+"");
                            tut = label[i][k];
                            label[i][k-1].setText("");    
                            sabit = false;
                        }
                    }
                }
            }
        }
        if (!sabit) {
            Timer t = new Timer(200, new ActionListener() {         
                 @Override
                 public void actionPerformed(ActionEvent e) {
                  birSayiUret(labelList);
                  renkleriBelirle(panelList, labelList);
                 }}); 
                 t.setRepeats(false);        
                 t.start();
        }        
        renkleriBelirle(panelList, labelList);
    }
    
    void sola(JLabel[][] label,ArrayList<JPanel> panelList,ArrayList<JLabel> labelList){
        boolean sabit = true;
        JLabel tut = null;
        for (int i = 0; i < label[0].length ; i++) {
            for (int j = 0; j < label.length; j++) {
                if (!label[i][j].getText().equals("")) {
                    String temp = label[i][j].getText();
                    int hold = j;
                    for (int k = j-1; 0 <= k; k--) {
                        if (label[i][k].getText().equals("")) {
                            label[i][k].setText(temp); 
                            hold--;
                            label[i][k+1].setText("");  
                            sabit = false;
                        }
                        else if (label[i][k].getText().equals(temp) && k == hold-1 && label[i][k] != tut) {
                            int sonuc = Integer.parseInt(label[i][k].getText())+Integer.parseInt(temp);
                            label[i][k].setText(sonuc+"");
                            int puan = Integer.parseInt(_2048.puan.getText());
                            _2048.puan.setText(puan+sonuc+"");
                            tut = label[i][k];
                            label[i][k+1].setText("");   
                            sabit = false;
                        }
                    }
                }
            }
        }
        if (!sabit) {
            Timer t = new Timer(200, new ActionListener() {         
                 @Override
                 public void actionPerformed(ActionEvent e) {
                  birSayiUret(labelList);
                  renkleriBelirle(panelList, labelList);
                 }}); 
                 t.setRepeats(false);        
                 t.start();
        }        
        renkleriBelirle(panelList, labelList);
    }
    
    void sayilariDagit(ArrayList<JLabel> labelList){
        Random r = new Random();
        int l1 = r.nextInt(16);
        int l2 = r.nextInt(16);
        int bir = r.nextInt(4)+1;
        int iki = r.nextInt(4)+1;
        while(bir % 2 != 0){
            bir = r.nextInt(4)+1;            
        }
        while(iki % 2 != 0){
           iki = r.nextInt(4)+1; 
        }        
        while(l1 == l2){
             l1 = r.nextInt(16);
             l2 = r.nextInt(16);
        }        
        labelList.get(l1).setText(bir+"");
        labelList.get(l2).setText(iki+"");
        
    }
    
    void renkleriBelirle(ArrayList<JPanel> panelList, ArrayList<JLabel> labelList){
         for (int i = 0; i < panelList.size(); i++) {
            if (labelList.get(i).getText().equals("")) {
                panelList.get(i).setBackground(Color.GRAY);
            }            
            else if (labelList.get(i).getText().equals("2")) {
                panelList.get(i).setBackground(Color.white);
            }
            else if(labelList.get(i).getText().equals("4")){
                panelList.get(i).setBackground(Color.LIGHT_GRAY);
            } 
            else if (labelList.get(i).getText().equals("8")) {
                panelList.get(i).setBackground(Color.yellow);
            }
            else if (labelList.get(i).getText().equals("16")) {
                panelList.get(i).setBackground(Color.orange);
            }
            else if (labelList.get(i).getText().equals("32")) {
                panelList.get(i).setBackground(Color.orange);
            }
            else if (labelList.get(i).getText().equals("64")) {
                panelList.get(i).setBackground(Color.red);
            }
            else if (labelList.get(i).getText().equals("128")) {
                panelList.get(i).setBackground(Color.yellow);
            }
            else if (labelList.get(i).getText().equals("256")) {
                panelList.get(i).setBackground(Color.orange);
            }
            else if (labelList.get(i).getText().equals("512")) {
                panelList.get(i).setBackground(Color.green);
            }
            else if (labelList.get(i).getText().equals("1024")) {
                panelList.get(i).setBackground(Color.BLUE);
            }
            else if (labelList.get(i).getText().equals("2048")) {
                panelList.get(i).setBackground(Color.MAGENTA);
            }
            else if (labelList.get(i).getText().equals("4096")) {
                panelList.get(i).setBackground(Color.pink);
            }
            else if (labelList.get(i).getText().equals("8192")) {
                panelList.get(i).setBackground(Color.pink);
            }
            else
                panelList.get(i).setBackground(Color.BLUE);
        }
     }
    
    void birSayiUret(ArrayList<JLabel> labelList){
         Random r = new Random();
         int sayi = r.nextInt(4)+1;
         int label = r.nextInt(16);
         while(sayi % 2 != 0){
            sayi = r.nextInt(4)+1;            
         }
         while(!labelList.get(label).getText().equals("")){
            label = r.nextInt(16);
         }         
         labelList.get(label).setText(sayi+"");
     }
    
    boolean bittiMi(JLabel[][] label){        
        boolean bittiMi = true;
        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label[i].length; j++) {
                if (label[i][j].getText().equals("")) {
                    bittiMi = false;
                    break;
                }
            }
        }
        return bittiMi;
    }
    
    void rekoruYaz(String rekor){
        Path p = Paths.get(System.getProperty("user.dir"));
            try {
                BufferedWriter b = new BufferedWriter(new FileWriter(p+"//rekor.txt"));
                b.flush();
                b.write(rekor);
                b.close();            
            } catch (IOException ex) {
                Logger.getLogger(Methods_2048.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    String rekoruOku(){
        String satir = "";
        Path p = Paths.get(System.getProperty("user.dir"));
        try {
              BufferedReader rekor = new BufferedReader(new FileReader(p+"//rekor.txt"));
              satir = rekor.readLine();
              rekor.close();
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(_2048.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(_2048.class.getName()).log(Level.SEVERE, null, ex);
          }
        return satir;
    }
    
    
    static public double power(double x, double y){
        double result = 1;
        if (x != 0 && y == 0)
            return result;
        else if (x == 0)
            return 0;
        else
            for (int i = 0; i < y; i++)
                result *= x;
        return result;
    }
    
    public static void main(String[] args) {
         System.out.println(power(5,78));
    }
    
       
    
    
    
}
