/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.login;

import java.util.Observable;
import java.util.Observer;
import sistemadeactivos.logic.Usuario;

/**
 *
 * @author mauri
 */
public class LoginModel extends Observable{
    Usuario current;
    
    public LoginModel() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Usuario());        
    }
    
    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
        this.commit();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

    public void commit(){
        setChanged();
        notifyObservers();       
    }
}
