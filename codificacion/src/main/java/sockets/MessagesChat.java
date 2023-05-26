/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

//import java.util.Observable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.subjects.PublishSubject;
/**
 *
 * @author kris_
 */
public class MessagesChat{
      private String mensaje;
      PublishSubject<String> subject = PublishSubject.create();
    
   
    
    public String getMensaje(){
        return mensaje;
    }
    
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
        // Indica que el mensaje ha cambiado
      //  this.setChanged();
        // Notifica a los observadores que el mensaje ha cambiado y se lo pasa
        // (Internamente notifyObservers llama al metodo update del observador)
    //    this.notifyObservers(this.getMensaje());
        subject.onNext(mensaje);
    }
    public PublishSubject getSubject$(){
        return this.subject;
    }

    
}
