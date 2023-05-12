package com.porfoliognz.ailin.gnz.Controller;

import com.porfoliognz.ailin.gnz.Dto.DtoEducacion;
import com.porfoliognz.ailin.gnz.Entity.Educacion;
import com.porfoliognz.ailin.gnz.Security.Controller.Mensaje;
import com.porfoliognz.ailin.gnz.Service.ServEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://frontendailingnz.web.app")

public class ContrEducacion {

    @Autowired
    ServEducacion servEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = servEducacion.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if (!servEducacion.existsById(id)){
        return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
    }
       Educacion educacion = servEducacion.getOne(id).get();
       return new ResponseEntity(educacion, HttpStatus.OK);
    }
    

    @DeleteMapping("/delete({id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!servEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        }
        servEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion) {
        if (StringUtils.isBlank(dtoEducacion.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (servEducacion.existsByNombreEdu(dtoEducacion.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("Nombre Existente"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(
                dtoEducacion.getNombreEdu(), dtoEducacion.getDescripcionEdu()
        );
        servEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion Creada"), HttpStatus.OK);
    }

    @PutMapping("/update{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion) {
        if (!servEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);

        }
        if (servEducacion.existsByNombreEdu(dtoEducacion.getNombreEdu()) && servEducacion.getByNombreEdu(dtoEducacion
                .getNombreEdu())
                .get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Nombre Existente"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = servEducacion.getOne(id).get();
        
        educacion.setNombreEdu(dtoEducacion.getNombreEdu());
        educacion.setDescripcionEdu(dtoEducacion.getDescripcionEdu());
        
        servEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion Actualizada"), HttpStatus.OK);
    }
      
        
}
