package Response;
import java.util.Date;

public class ComprobanteResponse {
    private Long id;
    private Date fecha;
    private double precioTotal;
    private int cantidadProductos;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    public int getCantidadProductos() {
        return cantidadProductos;
    }
    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }
    public ComprobanteResponse(Long id, Date fecha, double precioTotal, int cantidadProductos) {
        this.id = id;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.cantidadProductos = cantidadProductos;
    }

    
}
