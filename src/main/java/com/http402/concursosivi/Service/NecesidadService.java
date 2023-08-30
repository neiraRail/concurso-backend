package com.http402.concursosivi.Service;

import com.http402.concursosivi.Entity.NecesidadDataEntity;
import com.http402.concursosivi.Repository.NecesidadDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class NecesidadService {

    private final NecesidadDataRepository necesidadRepository;

    @Autowired
    public NecesidadService(NecesidadDataRepository necesidadRepository) {
        this.necesidadRepository = necesidadRepository;
    }

    public List<NecesidadDataEntity> getAllNecesidades() {
        return necesidadRepository.findAll();
    }

    public Optional<NecesidadDataEntity> getNecesidadById(Long id) {
        return necesidadRepository.findById(id);
    }

    public NecesidadDataEntity createNecesidad(NecesidadDataEntity necesidad) {
        return necesidadRepository.save(necesidad);
    }

    public NecesidadDataEntity updateNecesidad(Long id, NecesidadDataEntity necesidadDetails) {
        Optional<NecesidadDataEntity> existingNecesidadOptional = necesidadRepository.findById(id);

        if (existingNecesidadOptional.isPresent()) {
            NecesidadDataEntity existingNecesidad = existingNecesidadOptional.get();
            existingNecesidad.setNombreSolicitante(necesidadDetails.getNombreSolicitante());
            existingNecesidad.setRutSolicitante(necesidadDetails.getRutSolicitante());
            // Set other attributes as needed

            return necesidadRepository.save(existingNecesidad);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Necesidad no encontrada");
        }
    }

    public void deleteNecesidad(Long id) {
        necesidadRepository.deleteById(id);
    }
}

