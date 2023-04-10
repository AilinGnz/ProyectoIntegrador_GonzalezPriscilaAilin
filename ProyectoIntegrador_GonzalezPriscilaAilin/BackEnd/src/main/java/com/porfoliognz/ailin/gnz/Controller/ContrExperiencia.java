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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explaboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ContrExperiencia {

    @Autowired
    ServExperiencia servExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = servExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/Create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (servExperiencia.existsBynombreExp(dtoexp.getDescripcionExp())) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya es existente"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoexp.getNombreExp(), dtoexp.getDescripcionExp());
        servExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia añadida"), HttpStatus.OK);
    }

    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
        if (!servExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no es existe"), HttpStatus.BAD_REQUEST);

            if(servExperiencia.existsBynombreExp(dtoexp.getNombreExp()) && servExperiencia.getByNombreExp(dtoexp.getNombreexp()).get().getId() != id)
            return new ResponseEntity(new Mensaje ("Esa experiencia ya es excistente"), HttpStatus.BAD_REQUEST);
                
        
        }

    }
