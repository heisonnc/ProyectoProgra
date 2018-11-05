/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos;



import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import sistemadeactivos.logic.Funcionario;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Rol;
import sistemadeactivos.logic.Usuario;
import sistemadeactivos.presentation.administrador.ingresar.IngresarController;
import sistemadeactivos.presentation.administrador.ingresar.IngresarModel;
import sistemadeactivos.presentation.administrador.ingresar.IngresarView;
import sistemadeactivos.presentation.application.ApplicationController;
import sistemadeactivos.presentation.application.ApplicationModel;
import sistemadeactivos.presentation.application.ApplicationView;
import sistemadeactivos.presentation.catalogo.edicion.CatalogoEdicionController;
import sistemadeactivos.presentation.catalogo.edicion.CatalogoEdicionModel;
import sistemadeactivos.presentation.catalogo.edicion.CatalogoEdicionView;
import sistemadeactivos.presentation.catalogo.listado.CatalogosController;
import sistemadeactivos.presentation.catalogo.listado.CatalogosModel;
import sistemadeactivos.presentation.catalogo.listado.CatalogosView;
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
import sistemadeactivos.presentation.secretaria.SecretariaController;
import sistemadeactivos.presentation.secretaria.SecretariaModel;
import sistemadeactivos.presentation.secretaria.SecretariaView;
import sistemadeactivos.presentation.toolsBarcode.form.codeBarController;
import sistemadeactivos.presentation.toolsBarcode.form.codigobarras;

/**
 *
 * @author mauri
 */
public class Application {
    public static void main(String[] args) throws Exception{
        
        Model domainModel = Model.instance();
        Session session = new Session();
        
        
        
        
        domainModel.getUsuarios("a");
        
        List<Usuario> lis=domainModel.getUsuarios("a");
        
        for(Usuario user:lis){
            
            System.out.println(user.getFuncionario().getNombre());
        }
        
        
//        
//        Rol r= new Rol();
//        r=domainModel.getRol(Application.ROL_JEFE_RRHH);
//        System.out.println(r.getDescripcion());
//        Funcionario f= new Funcionario("Heison");
//        domainModel.addFuncionario(f);
//        r=domainModel.getRol(ROL_JEFE_RRHH);
//        
//        f=domainModel.getFuncionario("Heison");
//        Usuario user= new Usuario("001",f,r,"001");
//        domainModel.addUsuario(user);

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
        DependenciasController personascontroller = new DependenciasController(dependenciasView,dependenciasModel,domainModel,session);
        DEPENDENCIAS_CONTROLLER = personascontroller;
                
        DependenciaModel dependenciaModel = new DependenciaModel();        
        DependenciaView dependenciaView = new DependenciaView();
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
       
        
        
        IngresarModel ingresarModel = new IngresarModel();
        IngresarView ingresarView = new IngresarView();
        IngresarController ingresarController = new IngresarController(ingresarView,ingresarModel,domainModel,session);
        INGRESAR_CONTROLLER=ingresarController;
        
        SecretariaModel secretariaModel = new SecretariaModel(); 
        SecretariaView secretariaView = new SecretariaView();
        SecretariaController secretariaController = new SecretariaController(secretariaView, secretariaModel,domainModel, session);
        SECRETARIA_CONTROLLER = secretariaController;
        
        
        // instancias de catalogo 
        
        CatalogoEdicionModel catalogoEdiconModel = new CatalogoEdicionModel();
        CatalogoEdicionView catalogoEdicionView = new CatalogoEdicionView();
        CatalogoEdicionController catalogoEdicionController = new CatalogoEdicionController(catalogoEdicionView,catalogoEdiconModel,domainModel, session);
        CATALOGO_CONTROLLER=catalogoEdicionController;
        
        CatalogosModel catalogosModel= new CatalogosModel();
        CatalogosView catalogosView = new CatalogosView();
        CatalogosController catalogosController= new CatalogosController(catalogosView,catalogosModel,domainModel, session);
        CATALOGOS_CONTROLLER=catalogosController;
        
        // CODE BAR Controller
        
        codigobarras codigoView = new codigobarras();
        codeBarController codeBarController = new codeBarController(codigoView);
        CODEBAR_CONTROLLER=codeBarController;
        
    }
    public static LoginController LOGIN_CONTROLLER; 
    public static DependenciasController DEPENDENCIAS_CONTROLLER;
    public static DependenciaController DEPENDENCIA_CONTROLLER;
    
    // controladores para las pantallas de personal y edicion
    
    public static PersonalController PERSONAL_CONTROLLER;
    public static PersonalsController PERSONALS_CONTROLLER;
    public static SecretariaController SECRETARIA_CONTROLLER; 
    // controladores para la panatalla de ingresar
    
    public static IngresarController INGRESAR_CONTROLLER;
    
    // Controladores para el catalogo de administrador
    public static CatalogoEdicionController CATALOGO_CONTROLLER;
    public static CatalogosController  CATALOGOS_CONTROLLER;
    // Controlador para el codigo de barras
    public static codeBarController CODEBAR_CONTROLLER;
    
    
//    public static 
    public static final String USER_ATTRIBUTE = "User";
    public static ApplicationController APPLICATION_CONTROLLER; 
    
    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    public static final int MODO_CONSULTAR=2;
    public static  final int  MODO_AGREGAR_DEP=3;
    
    public static final Color COLOR_ERROR = Color.red;
    public static final Color COLOR_OK=Color.black;
    
    public static  final String  ROL_JEFE_OCCB="Jefe OCCB";
    public static  final String  ROL_JEFE_RRHH="Jefe RRHH";
    public static  final String  ROL_JEFE_RRHH_DEPENDENCIA="Jefe RRHH DEP";

    public static  final String  ROL_REGISTRADOR="Registrador";
    public static  final String  ROL_SECRETARIA="Secretaria";
    public static  final String  ROL_ADMINISTRADOR="Administrador";
    
    public static  final String  ROL_NOTAUTHORIZED="No Autorizado!";
}
