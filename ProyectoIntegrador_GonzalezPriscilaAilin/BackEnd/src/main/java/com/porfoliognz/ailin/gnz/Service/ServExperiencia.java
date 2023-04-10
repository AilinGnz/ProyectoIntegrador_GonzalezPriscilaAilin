package com.porfoliognz.ailin.gnz.Service;

import com.porfoliognz.ailin.gnz.Entity.Experiencia;
import com.porfoliognz.ailin.gnz.Repository.RepoExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ServExperiencia {

    @Autowired
    RepoExperiencia repoExperiencia;

    public List<Experiencia> list() {
        return repoExperiencia.findAll();

    }

    public Optional<Experiencia> getOne(int id) {
        return repoExperiencia.findById(id);
    }

    public Optional<Experiencia> getByNombreExp(String NombreExp) {
        return repoExperiencia.findByNombreExp(NombreExp);
    }

    public void save(Experiencia exp) {
        repoExperiencia.save(exp);
    }

    public void delete(int id) {
        repoExperiencia.deleteById(id);
    }

    public boolean existsById(int id) {
        return repoExperiencia.existsById(id);
    }

    public boolean existsBynombreExp(String nombreExp) {
        return repoExperiencia.existByNombreExp(nombreExp);
    }

    public boolean existsByNombreExp(CharSequence nombreExp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
