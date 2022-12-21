/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import codeFiles.Compress;
import codeFiles.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
//extending the abstract class JFrame
//implements ActionListener interface - whenever there is an action /click on component use this interface
public class View extends JFrame implements ActionListener{
    //declaring buttons
    JButton compressButton;
    JButton decompressButton;
    public View(){
        //for close button in frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //for layout
        this.setLayout(null);
        //for dimensions
        this.setSize(500, 300);
        //for changing the background color
        this.getContentPane().setBackground(Color.DARK_GRAY);
        
        //creating objects for buttons
        compressButton = new JButton("select file to compress");
        compressButton.addActionListener(this);
        //set boundaries
        compressButton.setBounds(20, 100, 200, 30);
        
        //creating objects for buttons
        decompressButton = new JButton("select file to decompress");
        //
        decompressButton.addActionListener(this);
        //set boundaries
        decompressButton.setBounds(250, 100, 200, 30);
        
        //add buttons to jframe
        this.add(compressButton);
        this.add(decompressButton);
         
    }
    
  @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Compress.compressFunction(file);
                }
                catch(Exception ep){
                    JOptionPane.showMessageDialog(null, ep.toString());
                }
                
            }
            
        }
        if(e.getSource()==decompressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Decompress.decompressFunction(file);
                }
                catch(Exception ep){
                    JOptionPane.showMessageDialog(null, ep.toString());
                }
                
            }
            
        }
    }
    
    

    
    
}
