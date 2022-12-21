/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author dell
 */
public class Decompress {
    public static void decompressFunction(File file) throws IOException{
        String fDirectory=file.getParent();
        System.out.println(fDirectory);
        FileInputStream fin=new FileInputStream(file);
        GZIPInputStream gzipin=new GZIPInputStream(fin);
        FileOutputStream fout=new FileOutputStream(fDirectory+"//DecompressedFile.txt");
        
        byte[] buffer=new byte[1024];
        int len;
        
        while((len=gzipin.read(buffer))!=-1){
            fout.write(buffer,0,len);
        }
        fout.close();
        gzipin.close();
        fin.close();
        
    }
    public static void main(String[] args) throws IOException{
        File path=new File("C:\\Program Files\\NetBeans-16\\netbeans\\NetBeansProjects\\CompressorDecompressorProject\\src\\codeFiles\\CompressedFile.gz");
        decompressFunction(path);
    }
    
}
