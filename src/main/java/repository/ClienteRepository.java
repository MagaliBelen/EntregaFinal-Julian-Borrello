package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ClienteModel;
import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository <ClienteModel, Long> {
    Optional<ClienteModel> findByCodigo (int id);
}
