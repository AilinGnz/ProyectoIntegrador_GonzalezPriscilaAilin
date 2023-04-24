package com.porfoliognz.ailin.gnz.Controller;

import com.porfoliognz.ailin.gnz.Dto.dtoExperiencia;
import com.porfoliognz.ailin.gnz.Entity.Experiencia;
import com.porfoliognz.ailin.gnz.Security.Controller.Mensaje;
import com.porfoliognz.ailin.gnz.Service.ServExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class ContrExperiencia {

    @Autowired
    ServExperiencia servExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = servExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!servExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = servExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreExp())) 
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (servExperiencia.existsByNombreExp(dtoExp.getNombreExp())) 
            return new ResponseEntity(new Mensaje("Experiencia Existente"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoExp.getNombreExp(), dtoExp.getDescripcionExp());
        servExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia Añadida"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoExp) {
        if (!servExperiencia.existsById(id)) 
            return new ResponseEntity(new Mensaje("ID inexcistente"), HttpStatus.BAD_REQUEST);
        
        if (servExperiencia.existsByNombreExp(dtoExp.getNombreExp()) && servExperiencia.getByNombreExp(dtoExp.getNombreExp()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Experiencia Excistente"), HttpStatus.BAD_REQUEST);

        if (StringUtils.isBlank(dtoExp.getNombreExp())) 
        return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
            

        Experiencia experiencia = servExperiencia.getOne(id).get();
        experiencia.setNombreExp(dtoExp.getNombreExp());
        experiencia.setDescripcionExp((dtoExp.getDescripcionExp()));

        servExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
        }
    
    public ResponseEntity<?> delete(@PathVariable("id") int id){
         if (!servExperiencia.existsById(id)) 
            return new ResponseEntity(new Mensaje("ID inexcistente"), HttpStatus.BAD_REQUEST);
        
         servExperiencia.delete(id);
         
         return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
