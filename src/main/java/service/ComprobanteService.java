package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.ClienteModel;
import model.ProductoModel;
import model.Comprobante;
import model.LineaVenta;

import repository.ClienteRepository;
import repository.ProductoRepository;
import repository.ComprobanteRepository;

import java.util.List;
import java.util.Date;



// Resto de tus importaciones


@Service
public class ComprobanteService {


    private ComprobanteRepository comprobanteRepository;


    private ClienteRepository clienteRepository;

  
    private ProductoRepository productoRepository;

   
    public Comprobante crearComprobante(Long clienteId, List<LineaVenta> lineas) {
         //Calcular el Precio Total y la Cantidad de Productos:
            double precioTotal = 0.0;
            int cantidadTotal = 0;

        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        for (LineaVenta linea : lineas) {
             double precioUnitario = linea.getProducto().getPrecio(); // Precio del producto en la línea
             int cantidad = linea.getCantidad();

            precioTotal += precioUnitario * cantidad;
            cantidadTotal += cantidad;

            ProductoModel producto = productoRepository.findById(linea.getProducto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

            if (linea.getCantidad() > producto.getStock()) {
                throw new IllegalArgumentException("Cantidad solicitada mayor que el stock disponible");
            }

            linea.setPrecioUnitario(producto.getPrecio()); // Establecer el precio unitario del producto en ese momento

            int nuevoStock = producto.getStock() - linea.getCantidad();
            producto.setStock(nuevoStock);
            productoRepository.save(producto);

            linea.setProducto(producto);

        }

        Comprobante comprobante = new Comprobante(clienteId, cliente, lineas);
        comprobante.setCliente(cliente);
        comprobante.setLineas(lineas);

        return comprobanteRepository.save(comprobante);
        
    }

        private RestTemplate restTemplate;

    @Autowired
    public ComprobanteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Date obtenerFechaComprobante() {
        try {
            String apiUrl = "http://worldclockapi.com/api/json/utc/now";
            WorldClockApiResponse response = restTemplate.getForObject(apiUrl, WorldClockApiResponse.class);
            if (response != null && response.getCurrentDateTime() != null) {
                return (Date) response.getCurrentDateTime();
            }
        } catch (Exception e) {
            
        }
        
        
        return new Date();
    }
    
}
