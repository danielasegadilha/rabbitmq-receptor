package com.senac.DanielaReceptorMulta.repository;

import com.senac.DanielaReceptorMulta.entities.Multa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Integer> {

    @Query("SELECT m FROM Multa m WHERE m.status >= 0")
    List<Multa> getAllMultas();

    @Query("SELECT m FROM Multa m WHERE m.status >= 0 AND m.id = :id")
    Optional<Multa> getMultaAtivaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Multa m SET m.status = -1 WHERE m.id = :id")
    void markAsDeleteMulta(@Param("id") int id);
}