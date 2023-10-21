package com.co.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Carlos Hernández
 * Clase encargada de guardar datos basicos para realizar
 * la exportacion
 */
public class ExportacionDTO {
    private List<ProductoDTO> productos;
    private String formaEnvio;
    private Date fechaEnvio;
    private Date fechaEstimadaLlegada;
    private PersonaDTO remitente;
    private PersonaDTO destinatario;
    private String formaPago;
    private double valorImpuestos;
    private String consecutivo;
    private String monedaPago;
    private Double valorTotal;
    
    public static final List<String> formasEnvio = new ArrayList<>();
    public static final List<String> formasPago = new ArrayList<>();
    static{
        formasEnvio.add("Marítimo");
        formasEnvio.add("Terrestre");
        formasEnvio.add("aéreo");
        
        formasPago.add("Transferencia Bancaria");
        formasPago.add("Tarjeta de crédito");
        formasPago.add("Cheque");
    }
    /**
     * Metodo encargado de realizar la conversión a dolares
     @param tasaConversion Objeto para poder realizar la operacion y mostrar el valor
     * @return el valor total convertido en dolares
     **/
    public double valorExportacionDolares(TasaConversionDTO tasaConversion){
        if(valorTotal == null || tasaConversion.getValor() == null){
            return 0.0;
        }
        return valorTotal / tasaConversion.getValor();
    }
    
    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }

    public String getFormaEnvio() {
        return formaEnvio;
    }

    public void setFormaEnvio(String formaEnvio) {
        this.formaEnvio = formaEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEstimadaLlegada() {
        return fechaEstimadaLlegada;
    }

    public void setFechaEstimadaLlegada(Date fechaEstimadaLlegada) {
        this.fechaEstimadaLlegada = fechaEstimadaLlegada;
    }

    public PersonaDTO getRemitente() {
        return remitente;
    }

    public void setRemitente(PersonaDTO remitente) {
        this.remitente = remitente;
    }

    public PersonaDTO getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(PersonaDTO destinatario) {
        this.destinatario = destinatario;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public double getValorImpuestos() {
        return valorImpuestos;
    }

    public void setValorImpuestos(double valorImpuestos) {
        this.valorImpuestos = valorImpuestos;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getMonedaPago() {
        return monedaPago;
    }

    public void setMonedaPago(String monedaPago) {
        this.monedaPago = monedaPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
