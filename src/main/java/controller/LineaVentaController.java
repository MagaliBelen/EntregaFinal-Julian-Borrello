package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import model.LineaVenta;
import service.LineaVentaService;

@RestController
@RequestMapping("/api/lineasventa")
public class LineaVentaController {

    private LineaVentaService lineaVentaService;

    @Autowired
    public LineaVentaController(LineaVentaService lineaVentaService) {
        this.lineaVentaService = lineaVentaService;
    }

    @PostMapping
    public ResponseEntity<LineaVenta> crearLineaVenta(@RequestBody LineaVenta lineaVenta) {
        LineaVenta nuevaLineaVenta = lineaVentaService.crearLineaVenta(lineaVenta);
        return new ResponseEntity<>(nuevaLineaVenta, HttpStatus.CREATED);
    }

    @GetMapping("/{lineaVentaId}")
    public ResponseEntity<LineaVenta> obtenerLineaVentaPorId(@PathVariable int lineaVentaId) {
        LineaVenta lineaVenta = lineaVentaService.obtenerLineaVentaPorId(lineaVentaId);
        if (lineaVenta != null) {
            return new ResponseEntity<>(lineaVenta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
