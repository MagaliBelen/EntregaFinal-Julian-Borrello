package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.Date;

import Response.ComprobanteResponse;
import model.Comprobante;
import service.ComprobanteService;
import model.LineaVenta;



@RestController
@RequestMapping("/comprobantes")
public class ComprobanteController {
    
    private ComprobanteService comprobanteService;

    @PostMapping
    public ResponseEntity<ComprobanteResponse> crearComprobante(@RequestBody Comprobante comprobante) {
        Comprobante nuevoComprobante = comprobanteService.crearComprobante(null, null);

        Date fechaComprobante = comprobanteService.obtenerFechaComprobante();
        double precioTotal = 0.0;
        int cantidadTotal = 0;

        for (LineaVenta linea : nuevoComprobante.getLineas()) {
            precioTotal += linea.getProducto().getPrecio() * linea.getCantidad();
            cantidadTotal += linea.getCantidad();
        }

        ComprobanteResponse response = new ComprobanteResponse(null, fechaComprobante, precioTotal, cantidadTotal);
        response.setId(nuevoComprobante.getId());
        response.setFecha(fechaComprobante);
        response.setPrecioTotal(precioTotal);
        response.setCantidadProductos(cantidadTotal);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}


