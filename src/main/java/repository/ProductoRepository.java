package repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.ProductoModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long>{

	
	Optional<ProductoModel> findByCodigo (String codigo);
	
}
