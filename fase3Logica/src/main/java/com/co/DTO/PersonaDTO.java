package com.co.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Carlos Hernández
 * Clase encargada de guardar los datos basicos del remitente y destinatario
 * de la exportación
 */
public class PersonaDTO {
    private String nombre;
    private Date fechaNacimiento;
    private String tipoid;
    private String identificacion;
    private String cargo;
    private String codigo;

    public static final Map<String, String> mapaTipoId = new HashMap<>();
    
    static{
        mapaTipoId.put("CC", "Cedula de ciudadania");
        mapaTipoId.put("CE", "Cedula de extranjeria");
        mapaTipoId.put("NIT", "Nit");
        mapaTipoId.put("PASAPORTE", "Pasaporte");
    }
    /**
     * Metodo encargado de calcular la edad de la persona dependiendo de la fecha de nacimiento
     * @return la edad actual de la persona
     * @throws java.lang.Exception
     **/
    public int calcularEdad()throws Exception{
        if(nombre == null || nombre.trim().equals("")){
            throw new Exception("La Persona debe tener nombre");
        }
        if(fechaNacimiento == null){
            throw new Exception("La Persona " + nombre + " No tiene una fecha de nacimiento.");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");                           
        int nacimiento = Integer.parseInt(sdf.format(fechaNacimiento));                            
        int actual = Integer.parseInt(sdf.format(new Date()));                                                       
        int edad = (actual - nacimiento) / 10000;
        return edad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
