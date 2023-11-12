package com.co.logica;

import com.co.DTO.ExportacionDTO;
import com.co.DTO.PersonaDTO;
import com.co.DTO.ProductoDTO;
import com.co.DTO.TasaConversionDTO;
import com.co.servicios.ExportarSvc;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author User
 */

@ManagedBean(name = "faseTresUI")
@SessionScoped
public class FaseTresUI {
    
    private final List<String> productos = ProductoDTO.PRODUCTOS;
    private List<ProductoDTO> productosExportar = new ArrayList<>();
    private Map<String, String> mapaCiudades = ProductoDTO.MAPACIUDADES;
    private ProductoDTO producto = new ProductoDTO();
    private String mensaje;
    private String severity;
    public FaseTresUI() {}
    
    @PostConstruct
    public void init(){
        productosExportar = new ArrayList<>();
        severity = "";
        mensaje = "";
    }
    
    public void agregarProducto(){
        if(productosExportar == null){
            productosExportar = new ArrayList<>();
        }
        try{
            if(producto.getNombre() == null || producto.getNombre().trim().equals("")){
                throw new Exception("Debe seleccionar un producto");
            }
            productosExportar.add(producto);
            producto = new ProductoDTO();
            severity = "info";
            mensaje = "Producto agregado correctamente";
        }catch(Exception e){
            severity = "warn";
            mensaje = e.getMessage();
        }
    }
    public void exportar(){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PersonaDTO remitente = new PersonaDTO();
            remitente.setCargo("REMITENTE");
            remitente.setNombre("REMITENTE");
            remitente.setFechaNacimiento(sdf.parse("1990-01-01"));
            int edadRemitente = remitente.calcularEdad();
            
            if(edadRemitente < 18){
                throw new Exception("El remitente no puede exportar porque es menor de edad.");
            }
            
            PersonaDTO destinatario = new PersonaDTO();
            destinatario.setCargo("DESTINATARIO");
            destinatario.setNombre("DESTINATARIO");
            destinatario.setFechaNacimiento(sdf.parse("1980-01-01"));
            int edadDestinatario = destinatario.calcularEdad();
            
            if(edadDestinatario < 18){
                throw new Exception("El destinatario no puede exportar porque es menor de edad.");
            }
            
            ExportacionDTO exportacion = new ExportacionDTO();
            exportacion.setConsecutivo(String.valueOf(System.currentTimeMillis()));
            exportacion.setProductos(productosExportar);
            exportacion.setFormaEnvio(ExportacionDTO.formasEnvio.get(0));
            exportacion.setFechaEnvio(new Date());
            exportacion.setFechaEstimadaLlegada(new Date());
            exportacion.setRemitente(remitente);
            exportacion.setDestinatario(destinatario);
            exportacion.setFormaPago(ExportacionDTO.formasPago.get(0));
            exportacion.setValorImpuestos(15000);
            exportacion.setMonedaPago("COP");
            exportacion.setValorTotal(150000.0);

            ExportarSvc exporSvc = new ExportarSvc();
            exporSvc.exportar(exportacion);
            productosExportar = new ArrayList<>();
            producto = new ProductoDTO();
            severity = "info";
            mensaje = "Exportación realizada correctamente";
        }catch(Exception e){
            severity = "warn";
            mensaje = e.getMessage();
        }
        
    }

    public List<ProductoDTO> getProductosExportar() {
        return productosExportar;
    }

    public void setProductosExportar(List<ProductoDTO> productosExportar) {
        this.productosExportar = productosExportar;
    }
    
    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
    
    public List<String> getProductos() {
        return productos;
    }

    public Map<String, String> getMapaCiudades() {
        return mapaCiudades;
    }

    public void setMapaCiudades(Map<String, String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
    
}
