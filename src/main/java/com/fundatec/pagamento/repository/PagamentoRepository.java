package com.fundatec.pagamento.repository;

import com.fundatec.pagamento.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *Classe respons[avel pela interface com o banco de dados
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
