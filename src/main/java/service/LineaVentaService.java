package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.LineaVenta;
import model.ProductoModel;
import repository.LineaVentaRepository;


@Service
public class LineaVentaService {

    private LineaVentaRepository lineaVentaRepository;

    @Autowired
    public LineaVentaService(LineaVentaRepository lineaVentaRepository) {
        this.lineaVentaRepository = lineaVentaRepository;
    }

    public LineaVenta crearLineaVenta(int cantidad, ProductoModel producto) {
        LineaVenta nuevaLineaVenta = new LineaVenta(null, cantidad, producto, null);
        nuevaLineaVenta.setCantidad(cantidad);
        nuevaLineaVenta.setProducto(producto);

      

        return lineaVentaRepository.save(nuevaLineaVenta);
    }

    public LineaVenta obtenerLineaVentaPorId(int id) {
        return lineaVentaRepository.findById(id).orElse(null);
    }

    public LineaVenta crearLineaVenta(LineaVenta lineaVenta) {
        return null;
    }


}

