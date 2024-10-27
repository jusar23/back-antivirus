package com.antivirus.backend.controller;

import com.antivirus.backend.model.Ubicaciones;
import com.antivirus.backend.service.UbicacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/antivirus/ubicaciones")
public class UbicacionesController {
    @Autowired
    private UbicacionesService ubicacionesService;
    // Crear un nueva Ubicaciones
    @PostMapping
    public Ubicaciones createUbicaciones(@RequestBody Ubicaciones ubicaciones) {
        return ubicacionesService.createUbicaciones(ubicaciones);
    }
    // Obtener todas las Ubicaciones
    @GetMapping
    public List<Ubicaciones> getAllUbicaciones() {
        return ubicacionesService.getAllUbicaciones();
    }
    // Obtener unas Ubicaciones por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ubicaciones> getUbicacionesById(@PathVariable Long id) {
        Optional<Ubicaciones> ubicaciones = ubicacionesService.getUbicacionesById(id);

        return ubicaciones.map(ResponseEntity::ok).orElseGet(() ->

                ResponseEntity.notFound().build());
    }
    // Actualizar un Persona
    @PutMapping("/{id}")
    public ResponseEntity<Ubicaciones> updateUbicaciones(@PathVariable Long id, @RequestBody
    Ubicaciones ubicacionesDetails) {
        return ResponseEntity.ok(ubicacionesService.updateUbicaciones(id, ubicacionesDetails));
    }
    // Eliminar una Ubicaciones
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUbicaciones(@PathVariable Long id) {
        ubicacionesService.deleteUbicaciones(id);
        return ResponseEntity.noContent().build();
    }
}