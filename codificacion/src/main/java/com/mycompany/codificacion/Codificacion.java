/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.codificacion;

/*import static com.mycompany.codificacion.Encriptation.c;
import static com.mycompany.codificacion.Encriptation.caracterASCII;
import static com.mycompany.codificacion.Encriptation.codigoOri;
import static com.mycompany.codificacion.Encriptation.findValueChar;
import static com.mycompany.codificacion.Encriptation.srtTrash;
import static com.mycompany.codificacion.Encriptation.tamanio;
import static com.mycompany.codificacion.Encriptation.vecDir;
import static com.mycompany.codificacion.Encriptation.vecDirTrash;
import static com.mycompany.codificacion.Encriptation.vecPos;
import static com.mycompany.codificacion.Encriptation.vecPosTrash;*/
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author kris_
 */
public class Codificacion {
    public static ArrayList<Integer> codigoOri = new ArrayList<>();
    public static ArrayList<Integer> codigoRan = new ArrayList<>();
    public static ArrayList<Character> caracterASCII = new ArrayList<>();
    public static ArrayList<Integer> vecPos = new ArrayList<>();
    public static ArrayList<Integer> vecDir = new ArrayList<>();
    public static ArrayList<Character> srtTrash = new ArrayList<>();
    public static ArrayList<String> encryp = new ArrayList<>();
    public static ArrayList<Integer> vecPosTrash = new ArrayList<>();
    public static ArrayList<Integer> vecDirTrash = new ArrayList<>();
    public static int tamanio = 256;
    public static String parteAnterior;
    public static String partePosterior;
    public static String nuevaCadena;
    public static String textEncryp, textTrash;
    public static char nuevoCaracter;
    public static int vueltas;
    
    public static Hashtable<Character, Integer> c = new Hashtable<>();
    
    public static void main(String token, String phraseEncr) {
        //limpiamos variables y listas
        clear();
        //Cargo nuestro diccionario
        textTrash = token;
        diccionary();//Llenamos nuestro diccionario
        //funcion de llenado del codigo ASCII el vector original con el vector 
        codAscii(codigoOri);
        codAscii(codigoRan);
        // Recuperar Valores de las posiciones dentro del token donde estan los caracteres que ocupamos
        fillVecTrash();
        // Recuperan ahora los valores enteros dependiendo el caracter
        retreviValuesToken();
        
        
        /*char car = 'A';
        System.out.println("Valor del caracter -> "+car+" es "+findValueInt(car));*/
        
    }
    
    // Poner el vector original revuelto de manera aleatoria en la encriptación 
    public static void vectorRan(){
        for(int i = 0; i<vueltas; i++){
            int j = 0;
            
            int dir = vecDir.get(i); // Recuperamos el valor hacia donde va a trasladarse izq o der
            int pos = vecPos.get(i); // posiciones a recorrer nuestro vector
            int temp;
            
            if(dir == 0){//recorrido izquierda
                while(j < pos){
                    // Mover los valores una posición a la izquierda
                   temp = codigoRan.get(0); // Guardar el primer elemento
                   for (int z = 0; z < codigoRan.size() - 1; z++) {
                        codigoRan.set(z, codigoRan.get(z + 1)); // Mover el elemento hacia la izquierda
                    }

                    codigoRan.set(codigoRan.size() - 1, temp); // Asignar el primer elemento en la última posición
                    
                    j++;
                }
                System.out.println("Lista desplazada a la izquierda: pos = "+pos);
                
            }else if(dir == 1){// recorrido derecha 
                //Recorro el vector las posiciones a la derecha
                while(j < pos){
                    
                    // Mover los valores una posición a la derecha
                    temp = codigoRan.get(codigoRan.size() - 1); // Guardar el último elemento

                    for (int z = codigoRan.size() - 1; z > 0; z--) {
                        codigoRan.set(z, codigoRan.get(z - 1)); // Mover el elemento hacia la derecha
                    }

                    codigoRan.set(0, temp); // Asignar el último elemento en la primera posición
                    j++;
                }
                System.out.println("Lista desplazada a la derecha: pos = "+pos);
                
            }
            formatPretty();
        }
    }
    
    //Un fromato agardable para ver el vector Random 
    public static void formatPretty(){
        
        for(int i = 0; i < codigoRan.size(); i++){
            System.out.print(i+": "+codigoRan.get(i)+" | ");
        }
        System.out.println("");
    }
    
    // Recupero los valores del Trash (Token) que nos van ayuda a desencriptar 
    public static void retreviValuesToken(){
        //recupero el valor a la que hace referencia ese caracter para el numero de vueltas
        vueltas = findValueInt(textTrash.charAt(299));
        //int numDir;
        //int numPos;
        for (int i = 0; i < vueltas; i++) {
            vecDir.add(findValueInt(textTrash.charAt(vecDirTrash.get(i))));
            vecPos.add(findValueInt(textTrash.charAt(vecPosTrash.get(i))));
            
        }
    }
    
    public static void clear(){
        vecDirTrash.clear();
        vecPosTrash.clear();
        vecPos.clear();
        vecDir.clear();
        encryp.clear();
        srtTrash.clear();
        caracterASCII.clear();
        codigoOri.clear();
        codigoRan.clear();
        
        textEncryp="";
        textTrash="";
    }
    
    public static int findValueInt(char chr){
        int numBuscado=-1;

        // Recorrer la Hashtable y buscar la clave asociada al valor buscado  
        for (Map.Entry<Character, Integer> entry : c.entrySet()) {
            if (entry.getKey()==chr) {
                numBuscado = entry.getValue();
                break;
            }
        }
        if(numBuscado == -1){
            System.out.println("No se encontró ninguna numero asociada a la clave");
        }
        return numBuscado;
    }
    
    //Lleno los vectores en las posiciones que vamos a ocupar en el trash para poner 
    //el direccion y las posiciones de desplazamiento
    public static void fillVecTrash(){
        // Llenado de vector hacia donde se fue izq o der encriptado
        vecDirTrash.add(25);
        vecDirTrash.add(17);
        vecDirTrash.add(12);
        vecDirTrash.add(278);
        vecDirTrash.add(146);
        vecDirTrash.add(200);
        vecDirTrash.add(85);
        vecDirTrash.add(250);
        vecDirTrash.add(129);
        vecDirTrash.add(99);
        vecDirTrash.add(111);
        
        // Llenado del vector de cuanto se desplazo encriptado
        vecPosTrash.add(184);
        vecPosTrash.add(300);
        vecPosTrash.add(296);
        vecPosTrash.add(149);
        vecPosTrash.add(40);
        vecPosTrash.add(320);
        vecPosTrash.add(70);
        vecPosTrash.add(60);
        vecPosTrash.add(13);
        vecPosTrash.add(38);
        vecPosTrash.add(244);
        
    }
    
    //Diccionario de que valor tiene dicho carater dentro de nuestro tocken llamado Trash
    public static void diccionary(){
        
        c.put('B',0);
        c.put('%',1);
        c.put('!',4);
        c.put('|',5);
        c.put('/',6);
        c.put('<',7);
        c.put(':',8);
        c.put('?',9);
        c.put('>',10);
        c.put('&',11);
        c.put('$',12);
        c.put('*',13);
        c.put(';',14);
        c.put('~',15);
        c.put('A',20);
        c.put('Z',21);
        c.put('T',22);
        c.put('Y',23);
        c.put('a',24);
        c.put('d',25);
        c.put('b',26);
        c.put('v',27);
        c.put('c',28);
        c.put('w',29);
        c.put('X',30);
        c.put('E',31);
        c.put('L',32);
        c.put('n',33);
        c.put('j',34);
        c.put('f',35);
        c.put('G',36);
        c.put('^',37);
        c.put('_',38);
        c.put('Z',39);
        c.put('K',40);
        c.put('p',41);
        c.put('s',42);
        c.put('q',43);
        c.put('o',44);
        c.put('i',45);
        c.put('.',46);
        c.put('-',47);
        c.put('@',48);
        c.put('#',49);
        c.put('=',50);
        
        //System.out.println(c.get('@'));
    }
    
    public static void castearIntChar(){
        for(int i = 0; i < tamanio; i++){
            caracterASCII.add(i, (char)codigoOri.get(i).intValue());
        }
        //System.out.println(caracterASCII);
    }
    
    //llenado del vector en codigo ASCII
    private static void codAscii(ArrayList<Integer> lista) {
        for(int i = 0; i<tamanio; i++){
            lista.add(i, i);
        }
    }
    
}
