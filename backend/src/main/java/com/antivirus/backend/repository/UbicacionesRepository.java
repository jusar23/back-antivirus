package com.antivirus.backend.repository;
import com.antivirus.backend.model.Ubicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionesRepository extends JpaRepository<Ubicaciones,Long>{
}
