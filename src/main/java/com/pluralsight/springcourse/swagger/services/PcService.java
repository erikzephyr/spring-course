package com.pluralsight.springcourse.swagger.services;

import com.pluralsight.springcourse.swagger.Exception.ItemNotFoundException;
import com.pluralsight.springcourse.swagger.model.Pc;
import com.pluralsight.springcourse.swagger.repository.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcService {

    @Autowired
    private PcRepository pcRepository;

    public Pc find(Long id) throws ItemNotFoundException {
        return pcRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Pc save(Pc pc) {
        return pcRepository.save(pc);
    }

    public void delete(Long id) {
        pcRepository.deleteById(id);
    }

    public Pc update(Pc newPc, Long id) {
        String hola = "hola";
        return pcRepository.findById(id)
                .map(pc -> {
                    pc.setPrice(newPc.getPrice());
                    pc.setBrand(newPc.getBrand());
                    pc.setScore(newPc.getScore());
                    return pcRepository.save(pc);
                })
                .orElseGet(() -> {
                    return pcRepository.save(newPc);
                });
    }

    public List<Pc> all() {
        return pcRepository.findAll();
    }
}
