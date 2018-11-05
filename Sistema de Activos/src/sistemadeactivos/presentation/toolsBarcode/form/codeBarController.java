/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.toolsBarcode.form;

/**
 *
 * @author book
 */
public class codeBarController {
    codigobarras codeBar;

    public codeBarController(codigobarras codeBar) {
        this.codeBar = codeBar;
    }
 
    public void setNum(int code){
        codeBar.setNumCode(code);
    }
    
    public void showCodeBar(){
        codeBar.setVisible(true);
    }
    
    public void hide(){
        codeBar.setVisible(false);
    }
}
