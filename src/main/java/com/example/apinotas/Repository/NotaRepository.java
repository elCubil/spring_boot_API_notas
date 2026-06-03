package com.example.apinotas.Repository;

import com.example.apinotas.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota,Long> {

    boolean existsByTitle(String titulo);

}
