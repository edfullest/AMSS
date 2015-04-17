package entidades;
import conexion.Conexion;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Anuncio {

  //Atributos propios de la clase
  private int idAnuncio;
  private String tituloAnuncio;
  private String descripcion;
  private String fechaPublicacion;

  //Atributos de la Conexion
  private Conexion conexion;

  //Constructor para inicializar la conexiÃ³n a la base de datos
  public Anuncio(){
        Conexion conexion=new Conexion();
  }
  
  
   public Anuncio(int idAnuncio,String tituloAnuncio, String descripcion, String fechaPublicacion){
        this.idAnuncio = idAnuncio;
        this.tituloAnuncio = tituloAnuncio;
        this.descripcion =  descripcion;
        this.fechaPublicacion = fechaPublicacion;
  }
   
    //El metodo de acontinuacion le da la oportunidad al usuario de subir un anuncio de interes
    public void darAltaAnuncio(int idAnuncio,String tituloAnuncio, String descripcion, String fechaPublicacion) {
        try {
         String s = 
           "INSERT INTO anuncio VALUES("+idAnuncio+","+tituloAnuncio+","+descripcion+","+fechaPublicacion+")";
         conexion.stmt.executeUpdate(s);
         
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
      
  }

    /**
     * @return the idAnuncio
     */
    public int getIdAnuncio() {
        return idAnuncio;
    }

    /**
     * @param idAnuncio the idAnuncio to set
     */
    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    /**
     * @return the tituloAnuncio
     */
    public String getTituloAnuncio() {
        return tituloAnuncio;
    }

    /**
     * @param tituloAnuncio the tituloAnuncio to set
     */
    public void setTituloAnuncio(String tituloAnuncio) {
        this.tituloAnuncio = tituloAnuncio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechaPublicacion
     */
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
  
  
  
}