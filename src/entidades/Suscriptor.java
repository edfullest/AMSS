package entidades;
import conexion.Conexion;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Suscriptor {

  //Atributos propios de la clase
  private int idSuscriptor;
  private String usuarioSuscriptor;
  private String nombreSuscriptor;
  private String contrasenaCuenta;
  private String fechaSuscripcion;
  private int tipoDeCuenta;
  private int tiempoSuscripcion;
  private String tarjetaDeCredito;
  private boolean esSuscriptor;

  //Atributos de la Conexion
  private Conexion conexion;

  //Constructor para inicializar la conexiÃ³n a la base de datos
  public Suscriptor(){
    Conexion conexion=new Conexion();
  }
  
  /*Este metodo sirve para hacer objetos de tipo Suscriptor con todos sus atributos 
   *inicializados con valores que ponga el usuario*/
  
  public Suscriptor(int id, String usuario, String nombreSuscriptor, String contrasenaCuenta,
    String fechaSuscripcion, int tipoDeCuenta, int tiempoSuscripcion, String tarjetaDeCredito, boolean esSuscriptor) {  
    this.idSuscriptor = id;
    this.usuarioSuscriptor = usuario;
    this.nombreSuscriptor = nombreSuscriptor;
    this.contrasenaCuenta= contrasenaCuenta;
    this.fechaSuscripcion = fechaSuscripcion;
    this.tipoDeCuenta = tipoDeCuenta;
    this.tiempoSuscripcion = tiempoSuscripcion;
    this.tarjetaDeCredito = tarjetaDeCredito;
    this.esSuscriptor = esSuscriptor;
  }
  
  /* Metodo para agregar suscriptores a la tabla "suscriptor" en el scheme(base de datos) de la conexion  
  */
  
    public void registrarSuscriptor(int id, String usuario, String nombreSuscriptor, String contrasenaCuenta,
    String fechaSuscripcion, int tipoDeCuenta, int tiempoSuscripcion, String tarjetaDeCredito, boolean esSuscriptor) {
      try {
         String s = 
           "INSERT INTO suscriptor VALUES("+id+","+usuario+","+nombreSuscriptor+","+contrasenaCuenta+","+fechaSuscripcion+","+tipoDeCuenta+","+tiempoSuscripcion+","+tarjetaDeCredito+","+esSuscriptor+")";
         conexion.stmt.executeUpdate(s);
         
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
  }
    
    /* Metodo para dar de baja suscripcion
     */
  
    public void darDeBaja(int id) {
      try {
         String s = "UPDATE suscriptor SET esSuscriptor = false  WHERE idSuscriptor = "+id+" ";
         conexion.stmt.executeUpdate(s);
         
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
  }
    /* Metodo para renovar Suscripcion del suscriptor
     */
  
    public void renovarSuscripcion(int id) {
      try {
         String s = "UPDATE suscriptor SET tiempoSuscripcion = 12  WHERE idSuscriptor = "+id+" ";
         conexion.stmt.executeUpdate(s);
         
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
  }
    
    //El metodo de acontinuacion verifica la credencial de login del suscriptor
    public boolean validarUsuario(String usuarioSuscriptor, String contrasenaCuenta) {
      try {
         String s = "SELECT usuarioSuscriptor FROM suscriptor WHERE (usuarioSuscriptor = " + usuarioSuscriptor +"AND contraseniaCuenta = " + contrasenaCuenta + ")";
         ResultSet rs = conexion.stmt.executeQuery(s);
         
         //Si el usuario introdujo usuario y contrase;a valida, el resultset tendra una entrada
         if (rs.next()){
             return true;
         }
         
         //Si no tiene ninguna entrada, de lo contrario el usuario introdujo algo mal
         else{
             return false;
         }
      } catch (SQLException e) {
          System.out.println ("Cannot execute disposicion()" + e); 
          return false;
      }
      
  }
    
    
    //A continuacion se ponen los getters y setters para objetos de la clase Suscriptor
    /**
     * @return  idSuscriptor
     */
    public int getIdSuscriptor() {
        return idSuscriptor;
    }

    /**
     * @param idSuscriptor  idSuscriptor a poner
     */
    public void setIdSuscriptor(int idSuscriptor) {
        this.idSuscriptor = idSuscriptor;
    }

    /**
     * @return  usuarioSuscriptor
     */
    public String getUsuarioSuscriptor() {
        return usuarioSuscriptor;
    }

    /**
     * @param usuarioSuscriptor  usuarioSuscriptor a poner
     */
    public void setUsuarioSuscriptor(String usuarioSuscriptor) {
        this.usuarioSuscriptor = usuarioSuscriptor;
    }

    /**
     * @return  nombreSuscriptor
     */
    public String getNombreSuscriptor() {
        return nombreSuscriptor;
    }

    /**
     * @param nombreSuscriptor  nombreSuscriptor a poner
     */
    public void setNombreSuscriptor(String nombreSuscriptor) {
        this.nombreSuscriptor = nombreSuscriptor;
    }

    /**
     * @return  contrasenaCuenta
     */
    public String getContrasenaCuenta() {
        return contrasenaCuenta;
    }

    /**
     * @param contrasenaCuenta  contrasenaCuenta a poner
     */
    public void setContrasenaCuenta(String contrasenaCuenta) {
        this.contrasenaCuenta = contrasenaCuenta;
    }

    /**
     * @return  fechaSuscripcion
     */
    public String getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    /**
     * @param fechaSuscripcion  fechaSuscripcion a poner
     */
    public void setFechaSuscripcion(String fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }

    /**
     * @return  tipoDeCuenta
     */
    public int getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    /**
     * @param tipoDeCuenta  tipoDeCuenta a poner
     */
    public void setTipoDeCuenta(int tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    /**
     * @return  tiempoSuscripcion
     */
    public int getTiempoSuscripcion() {
        return tiempoSuscripcion;
    }

    /**
     * @param tiempoSuscripcion  tiempoSuscripcion a poner
     */
    public void setTiempoSuscripcion(int tiempoSuscripcion) {
        this.tiempoSuscripcion = tiempoSuscripcion;
    }

    /**
     * @return  tarjetaDeCredito
     */
    public String getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    /**
     * @param tarjetaDeCredito  tarjetaDeCredito a poner
     */
    public void setTarjetaDeCredito(String tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    /**
     * @return  esSuscriptor
     */
    public boolean isEsSuscriptor() {
        return esSuscriptor;
    }

    /**
     * @param esSuscriptor  esSuscriptor a poner
     */
    public void setEsSuscriptor(boolean esSuscriptor) {
        this.esSuscriptor = esSuscriptor;
    }
    
    
}
