package com.porfoliognz.ailin.gnz.Controller;

import com.porfoliognz.ailin.gnz.Dto.DtohYs;
import com.porfoliognz.ailin.gnz.Entity.hYs;
import com.porfoliognz.ailin.gnz.Security.Controller.Mensaje;
import com.porfoliognz.ailin.gnz.Service.ServhYs;
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
@CrossOrigin(origins = "https://localhost:4200")
//@CrossOrigin (origins = "https://frontendailingnz.web.app")
@RequestMapping("/hys")
public class Contrhys {

    @Autowired
    ServhYs servhys;

    @GetMapping("/lista")
    public ResponseEntity<List<hYs>> list() {
        List<hYs> list = servhys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<hYs> getById(@PathVariable("id") int id) {
        if (!servhys.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        hYs hys = servhys.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!servhys.existsById(id)) {
            return new ResponseEntity(new Mensaje("Inexistente"), HttpStatus.NOT_FOUND);
        }
        servhys.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtohYs dtohYs) {
        if (StringUtils.isBlank(dtohYs.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (servhys.existsByNombre(dtohYs.getNombre())) {
            return new ResponseEntity(new Mensaje("Skill Existente"), HttpStatus.BAD_REQUEST);
        }

        hYs hys = new hYs(dtohYs.getNombre(), dtohYs.getPorcentaje());
        servhys.save(hys);

        return new ResponseEntity(new Mensaje("Skill  Añadida"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtohYs dtohys) {
        if (!servhys.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexcistente"), HttpStatus.BAD_REQUEST);
        }

        if (servhys.existsByNombre(dtohys.getNombre()) && servhys.getByNombre(dtohys.getNombre())
                .get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Skill Excistente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        hYs hys = servhys.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcentaje(dtohys.getPorcentaje());

        servhys.save(hys);
        return new ResponseEntity(new Mensaje("Skill Actualizada"), HttpStatus.OK);
    }
}
