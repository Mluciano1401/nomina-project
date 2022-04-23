/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 
package ManejadordeArchivos;
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.OutputStreamWriter; 
import java.io.PrintWriter; 
import java.io.UnsupportedEncodingException; 
import java.util.ArrayList; 
import java.util.Scanner; 
import javax.swing.JTextField;
/**
 *
 * @author María Luciano
 */
public class ManejadorArchivos {
    public String GuardarDatos (String data, String Archirvo) throws 
IOException{ 
        String Mensaje1 = null; 
        File F1= new File(Archirvo); 
        BufferedWriter escribir = null; 
        escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(F1, 
       true), "utf-8")); 

        try{ 
            if (!F1.exists()){ 
                F1.createNewFile(); 
            } 

            escribir.write(data); 
            escribir.close(); 
        } catch (Exception ex) { 
            Mensaje1=("Error al grabar Archivo " + ex); 
        } 
        return (Mensaje1) ; 
 } 
 
    public ArrayList LeerDatos(String codigo) throws FileNotFoundException, 
    UnsupportedEncodingException, IOException { 
        boolean encontrado=false; 
        int cod=Integer.parseInt(codigo); 
        ArrayList<String> ArrayListArchivo = new ArrayList<String>(); 

        File F1 = new File("e:archivoCte.txt"); 

        try { 
            if(!F1.exists()){ 
                F1.createNewFile(); 
            } 
            Scanner s = new Scanner(F1); 
            while (s.hasNextLine() && !encontrado) { 
                String linea = s.nextLine(); 
                Scanner sl = new Scanner(linea); 
                sl.useDelimiter("\\s*;\\s*"); 
                int codigoArc = Integer.parseInt(sl.next()); 

                if(cod==codigoArc){ 
                    encontrado=true; 
                    String nombre=sl.next(); 
                    String apellido=sl.next(); 
                    String edad=sl.next(); 
                    ArrayListArchivo.add("1"); 
                    ArrayListArchivo.add(nombre); 
                    ArrayListArchivo.add(apellido); 
                    ArrayListArchivo.add(edad); 
                } 
            }
            s.close(); 
        } catch (FileNotFoundException e1) { 
            System.out.println("Error al leer Archivo " + e1); 
        }  
        return(ArrayListArchivo);  
    }
 
    public void ModificaDatos(String codigo,String datavieja, String datanueva, String Archivon,String Archivov){ 
        boolean encontrado=false; 
        File fNuevo= new File(Archivon); 
        File fAntiguo= new File(Archivov); 
        String aCadena=datavieja; 
        String nCadena=datanueva; 
        int cod=Integer.parseInt(codigo); 
        try { 
            if(fAntiguo.exists()) { 
                String linea; 
                Scanner s = new Scanner(fAntiguo); 
                while (s.hasNextLine()){ 
                    linea = s.nextLine(); 
                    Scanner sl = new Scanner(linea); 
                    sl.useDelimiter("\\s*;\\s*"); 
                    int codigoArc = Integer.parseInt(sl.next()); 
                    if(cod==codigoArc){ 
                        Escribir(fNuevo,nCadena); 
                    } 
                    else { 
                        Escribir(fNuevo,linea); 
                    } 

                }
                s.close(); 
                String nAntiguo = fAntiguo.getName();   
                borrar(fAntiguo);
                fNuevo.renameTo(fAntiguo);      
                      
            } 
            else { 
                System.out.println("Fichero no Existe"); 
            } 
        }
        catch(Exception e) { 
            System.out.println(e); 
        } 
 
    }
    public void Escribir(File fFichero,String cadena) { 
        BufferedWriter bw; 
        try {
            if(!fFichero.exists()){ 
                fFichero.createNewFile(); 
            } 
            bw = new BufferedWriter(new FileWriter(fFichero,true)); 
            bw.write(cadena+"\r\n"); 
            bw.close(); 
        }catch(Exception e){ 
            System.out.println(e); 
        } 
 }
    public void borrar (File Ffichero){ 
        try{  
            if(Ffichero.exists()){ 
                Ffichero.delete(); 
                System.out.println("Fichero Borrado"); 
            } 
        }catch(Exception e){ 
            System.out.println("Fichero no fue Borrado"); 
            System.out.println(e); 
        } 
    }
    public void Delay(long milis){ 
        try { 
            Thread.sleep(milis); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
    }
}

