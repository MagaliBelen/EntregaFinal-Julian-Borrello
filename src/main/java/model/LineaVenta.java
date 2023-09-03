package model;
import javax.persistence.*;



@Entity
public class LineaVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;
     private double precioUnitario; 

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoModel producto;

    @ManyToOne
    @JoinColumn(name = "comprobante_id")
    private Comprobante comprobante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public LineaVenta(Long id, int cantidad, ProductoModel producto, Comprobante comprobante) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.comprobante = comprobante;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + cantidad;
        long temp;
        temp = Double.doubleToLongBits(precioUnitario);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((producto == null) ? 0 : producto.hashCode());
        result = prime * result + ((comprobante == null) ? 0 : comprobante.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LineaVenta other = (LineaVenta) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (cantidad != other.cantidad)
            return false;
        if (Double.doubleToLongBits(precioUnitario) != Double.doubleToLongBits(other.precioUnitario))
            return false;
        if (producto == null) {
            if (other.producto != null)
                return false;
        } else if (!producto.equals(other.producto))
            return false;
        if (comprobante == null) {
            if (other.comprobante != null)
                return false;
        } else if (!comprobante.equals(other.comprobante))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LineaVenta [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", producto="
                + producto + ", comprobante=" + comprobante + "]";
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
}
