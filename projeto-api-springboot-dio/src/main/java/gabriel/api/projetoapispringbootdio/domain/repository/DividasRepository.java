package gabriel.api.projetoapispringbootdio.domain.repository;

import gabriel.api.projetoapispringbootdio.domain.model.Dividas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividasRepository extends JpaRepository<Dividas, Long> {

}
