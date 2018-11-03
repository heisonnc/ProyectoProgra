/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos;



import java.awt.Color;
import sistemadeactivos.logic.Model;
import sistemadeactivos.presentation.application.ApplicationController;
import sistemadeactivos.presentation.application.ApplicationModel;
import sistemadeactivos.presentation.application.ApplicationView;
import sistemadeactivos.presentation.jeferrhh.dependencias.edicion.DependenciaController;
import sistemadeactivos.presentation.jeferrhh.dependencias.edicion.DependenciaModel;
import sistemadeactivos.presentation.jeferrhh.dependencias.edicion.DependenciaView;
import sistemadeactivos.presentation.jeferrhh.dependencias.listado.DependenciasController;
import sistemadeactivos.presentation.jeferrhh.dependencias.listado.DependenciasModel;
import sistemadeactivos.presentation.jeferrhh.dependencias.listado.DependenciasView;
import sistemadeactivos.presentation.jeferrhh.personal.edicion.PersonalController;
import sistemadeactivos.presentation.jeferrhh.personal.edicion.PersonalModel;
import sistemadeactivos.presentation.jeferrhh.personal.edicion.PersonalView;
import sistemadeactivos.presentation.jeferrhh.personal.listado.PersonalsController;
import sistemadeactivos.presentation.jeferrhh.personal.listado.PersonalsModel;
import sistemadeactivos.presentation.jeferrhh.personal.listado.PersonalsView;
import sistemadeactivos.presentation.login.LoginController;
import sistemadeactivos.presentation.login.LoginModel;
import sistemadeactivos.presentation.login.LoginView;

/**
 *
 * @author mauri
 */
public class Application {
    public static void main(String[] args){
        Model domainModel = Model.instance();
        Session session = new Session();
        
        ApplicationModel applicationModel = new ApplicationModel();
        ApplicationView applicationView= new ApplicationView();
        ApplicationController applicationController = new ApplicationController(applicationView,applicationModel,domainModel,session);
        APPLICATION_CONTROLLER = applicationController;
        
        LoginModel loginModel = new LoginModel();
        LoginView loginView= new LoginView();
        LoginController logincontroller = new LoginController(loginView,loginModel,domainModel,session);
        LOGIN_CONTROLLER = logincontroller;
        loginView.setVisible(true);
        
        DependenciasModel dependenciasModel = new DependenciasModel();
        DependenciasView dependenciasView= new DependenciasView();
        applicationView.addInternalFrame(dependenciasView);
        DependenciasController personascontroller = new DependenciasController(dependenciasView,dependenciasModel,domainModel,session);
        DEPENDENCIAS_CONTROLLER = personascontroller;
                
        DependenciaModel dependenciaModel = new DependenciaModel();        
        DependenciaView dependenciaView = new DependenciaView(applicationView,true);
        DependenciaController dependenciaController = new DependenciaController(dependenciaView,dependenciaModel,domainModel,session);
        DEPENDENCIA_CONTROLLER = dependenciaController;
        
        
        
        // Pantallas de rrhh personal
        PersonalModel personalModel = new PersonalModel();
        PersonalView personalVeiw = new PersonalView();
        PersonalController personalController = new PersonalController(personalVeiw,personalModel,domainModel,session);
        PERSONAL_CONTROLLER=personalController;
        
        
        
        PersonalsModel pesonalsModel= new PersonalsModel();
        PersonalsView personalsView = new PersonalsView();
        PersonalsController personalsController = new PersonalsController(personalsView,pesonalsModel, domainModel,session);
        PERSONALS_CONTROLLER=personalsController;

        
    }
    public static LoginController LOGIN_CONTROLLER; 
    public static DependenciasController DEPENDENCIAS_CONTROLLER;
    public static DependenciaController DEPENDENCIA_CONTROLLER;
    
    // controladores para las pantallas de personal y edicion
    
    public static PersonalController PERSONAL_CONTROLLER;
    public static PersonalsController PERSONALS_CONTROLLER;
//    public static 
    public static final String USER_ATTRIBUTE = "User";
    public static ApplicationController APPLICATION_CONTROLLER; 
    
    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    public static final int MODO_CONSULTAR=2;
    
    public static final Color COLOR_ERROR = Color.red;
    public static final Color COLOR_OK=Color.black;
    
    public static  final String  ROL_JEFE_OCCB="Jefe_OCCB";
    public static  final String  ROL_JEFE_RRHH="Jefe_RRHH";
    public static  final String  ROL_REGISTRADOR="Registrador";
    public static  final String  ROL_SECRETARIA="Secretaria";
    public static  final String  ROL_ADMINISTRADOR="Administrador";
    
    public static  final String  ROL_NOTAUTHORIZED="No Autorizado!";
}
