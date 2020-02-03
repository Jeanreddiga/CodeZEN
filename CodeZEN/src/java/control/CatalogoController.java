/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.CatalogoDAO;
import dao.CatalogoDAOImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Catalogo;

/**
 *
 * @author jcreddiga
 */
@ManagedBean(name="CatalogoController")
@SessionScoped
public class CatalogoController {
      private Catalogo catalogo;
      private DataModel<Catalogo> listaCatalogos;
      private String msg;
       
      public Catalogo getCatalogo() {
            return catalogo;
      }
       
      public void setCatalogo(Catalogo catalogo) {
            this.catalogo = catalogo;
      }      
       
      public DataModel<Catalogo> getListaCatalogos() {
             
            CatalogoDAO dao = new CatalogoDAOImpl();
            List<Catalogo> lista = dao.listarCatalogos();
            listaCatalogos = new ListDataModel<Catalogo>(lista);
            return listaCatalogos;
      }
  
      public void setListaCatalogos(DataModel<Catalogo> listaCatalogos) {
            this.listaCatalogos = listaCatalogos;
      }
  
      public String getMsg() {
            return msg;
      }
  
      public void setMsg(String msg) {
            this.msg = msg;
      }
  
      public String adicionarForm() {
             catalogo = new Catalogo();
           
          return "inserir_catalogo_form"; 
      }
       
      public String adicionarCatalogo() {
        
             CatalogoDAO dao = new CatalogoDAOImpl();
             dao.adicionarCatalogo(catalogo); 
           
             setMsg("Salvo com sucesso!");
             return "inserir_catalogo_form"; 
      }
       
      public String listarForm() {
           
             return "index"; 
      }
       
       
      @PostConstruct
      public void init() {
             catalogo = new Catalogo();
      }    
}
