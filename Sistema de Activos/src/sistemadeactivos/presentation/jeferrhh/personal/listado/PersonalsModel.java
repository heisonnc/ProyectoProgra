/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.personal.listado;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author xxxx
 */
public class PersonalsModel extends Observable{
    
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        refresh();
    }
    
    public void refresh(){
        setChanged();
        notifyObservers();
    }
}
