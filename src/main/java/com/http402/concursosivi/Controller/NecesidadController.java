package com.http402.concursosivi.Controller;
import com.http402.concursosivi.Entity.NecesidadDataEntity;
import com.http402.concursosivi.Service.NecesidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/necesidad")
public class NecesidadController {
    private final NecesidadService necesidadService;
    @Autowired
    public NecesidadController(NecesidadService necesidadService) {
        this.necesidadService = necesidadService;
    }

    @GetMapping("/{id}")
    public NecesidadDataEntity getNecesidadById(@PathVariable Long id){
        return necesidadService.getNecesidadById(id).get();
    }
    @GetMapping("/all")
    public List<NecesidadDataEntity> getAllNecesidades() {
        return necesidadService.getAllNecesidades();
    }
    @PostMapping
    public NecesidadDataEntity createNecesidad(@RequestBody NecesidadDataEntity necesidad){
        return necesidadService.createNecesidad(necesidad);
    }
    @PostMapping("/{id}")
    public NecesidadDataEntity updateNecesidad(@PathVariable Long id, @RequestBody NecesidadDataEntity necesidad){
        return necesidadService.updateNecesidad(id, necesidad);
    }
    @DeleteMapping("/{id}")
    public void deleteNecesidad(@PathVariable Long id){
        necesidadService.deleteNecesidad(id);
    }

    @DeleteMapping("/all")
    public void deleteAll(){
        necesidadService.deleteAllNecesidades();
    }
    @GetMapping("/pagination/{start}")
    public List<NecesidadDataEntity> getNecesidadesByStart(@PathVariable int start) {
        int pageSize = 12; // Tamaño de la página
        int startIndex = start - 1;

        List<NecesidadDataEntity> necesidades = necesidadService.getNecesidadesByStart(startIndex, pageSize);

        return necesidades;
    }
    @GetMapping("/palabras-clave")
    public Map<String, Integer> getPalabrasClaveMasRepetidas() {
        List<String> palabrasClave = necesidadService.getAllPalabrasClave();

        // Contar las repeticiones de las palabras clave
        Map<String, Integer> repeticiones = new HashMap<>();
        for (String palabras : palabrasClave) {
            String[] palabrasIndividuales = palabras.split("\\*"); // Separar las palabras clave
            for (String palabraClave : palabrasIndividuales) {
                repeticiones.put(palabraClave, repeticiones.getOrDefault(palabraClave, 0) + 1);
            }
        }

        // Seleccionar las palabras clave más repetidas (pueden ser las 10 más repetidas, por ejemplo)
        Map<String, Integer> palabrasClaveMasRepetidas = repeticiones.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) // Ordenar por repeticiones descendentes
                .limit(20) // Limitar a las 10 más repetidas
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // Palabra clave
                        Map.Entry::getValue // Cantidad de repeticiones
                ));

        return palabrasClaveMasRepetidas;
    }

    @PostMapping("/incrementar-visita")
    public void incrementarVisita(@RequestParam Long id) {
        necesidadService.incrementarVisita(id);
    }
}
