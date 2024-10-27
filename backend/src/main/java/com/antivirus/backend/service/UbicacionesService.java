package com.antivirus.backend.service;
import com.antivirus.backend.model.Ubicaciones;
import com.antivirus.backend.repository.UbicacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UbicacionesService {
    @Autowired
    private UbicacionesRepository UbicacionesRepository;
    // Crear un nuevo Ubicaciones
    public Ubicaciones createUbicaciones(Ubicaciones ubicaciones) {
        return UbicacionesRepository.save(ubicaciones);
    }
    // Obtener un Ubicaciones por ID
    public Optional<Ubicaciones> getUbicacionesById(Long id) {
        return UbicacionesRepository.findById(id);
    }
    // Obtener todas las Ubicaciones
    public List<Ubicaciones> getAllUbicaciones() {
        return UbicacionesRepository.findAll();
    }
    // Actualizar un usuario
    public Ubicaciones updateUbicaciones(Long id, Ubicaciones ubicacionesDetails) {
        Ubicaciones ubicaciones = UbicacionesRepository.findById(id).orElseThrow();
        ubicaciones.setDepartamento(ubicacionesDetails.getDepartamento());
        ubicaciones.setMunicipio(ubicacionesDetails.getMunicipio());
        ubicaciones.setVirtual(ubicacionesDetails.isVirtual());
        return UbicacionesRepository.save(ubicaciones);
    }
    // Eliminar una Ubicaciones
    public void deleteUbicaciones(Long id) {
        UbicacionesRepository.deleteById(id);
    }
}
