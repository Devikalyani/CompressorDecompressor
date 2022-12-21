/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author dell
 */
public class Compress {
    public static void compressFunction(File file) throws FileNotFoundException,IOException{
        //store the file directory into string
        //C:\Program Files\NetBeans-16\netbeans\NetBeansProjects\CompressorDecompressorProject\src\codeFiles
        String fDirectory=file.getParent();
        //1.declaring the objects which are used to compress the files
        //input the file data into fileinputstream - reading content as bytes
        FileInputStream fin=new FileInputStream(file);
        //store the output file in same directory with extension gz
        FileOutputStream fout=new FileOutputStream(fDirectory+"\\CompressedFile.gz");
        //we are converting the byte files into compressed version - zipfile format
        GZIPOutputStream Gzip=new GZIPOutputStream(fout);
        //declare the byte array
        byte[] buffer=new byte[1024];
        int len;
        while((len=fin.read(buffer))!=-1){
            Gzip.write(buffer,0,len);
        }
        Gzip.close();
        fout.close();
        fin.close();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException{
    File path=new File("C:\\Program Files\\NetBeans-16\\netbeans\\NetBeansProjects\\CompressorDecompressorProject\\src\\codeFiles\\textfile.txt");
    compressFunction(path);
    }
    
}
