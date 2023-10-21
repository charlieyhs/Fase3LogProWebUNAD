package com.co.DTO;

import java.util.Date;

/**
 *
 * @author Carlos Hernández
 * Clase encargada de guardar los datos basicos para realizar 
 * Conversion de las monedas
 */
public class TasaConversionDTO {
    private String codigo;
    private Date desde;
    private Date hasta;
    private String monedaDesde;
    private String monedaHacia;
    private Double valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getMonedaDesde() {
        return monedaDesde;
    }

    public void setMonedaDesde(String monedaDesde) {
        this.monedaDesde = monedaDesde;
    }

    public String getMonedaHacia() {
        return monedaHacia;
    }

    public void setMonedaHacia(String monedaHacia) {
        this.monedaHacia = monedaHacia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }   
}
