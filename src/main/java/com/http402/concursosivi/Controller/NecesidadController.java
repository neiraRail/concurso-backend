package com.http402.concursosivi.Controller;
import com.http402.concursosivi.Entity.NecesidadDataEntity;
import com.http402.concursosivi.Service.NecesidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
