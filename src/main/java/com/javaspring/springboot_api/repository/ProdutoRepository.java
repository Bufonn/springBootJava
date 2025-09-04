package com.javaspring.springboot_api.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaspring.springboot_api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nome);
    List<Produto> findByNomeContaining(String parteDoNome);
}
