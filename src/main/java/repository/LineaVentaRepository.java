package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.LineaVenta;

@Repository
public interface LineaVentaRepository extends JpaRepository<LineaVenta, Integer> {

   Optional<LineaVenta> findByCodigo (int id);
}
