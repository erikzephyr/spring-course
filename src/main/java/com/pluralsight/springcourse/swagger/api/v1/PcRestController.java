package com.pluralsight.springcourse.swagger.api.v1;

import com.pluralsight.springcourse.swagger.Exception.ItemNotFoundException;
import com.pluralsight.springcourse.swagger.model.Pc;
import com.pluralsight.springcourse.swagger.services.PcService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log
@RequestMapping("v1/pcs")
@RestController("PcRestControllerV1")
public class PcRestController {

    @Autowired
    private PcService pcService;

    @GetMapping("all")
    @ApiOperation(value = "all", notes = "Return a list of pc's stored")
    public List<Pc> all() {
        return pcService.all();
    }

    @GetMapping("find")
    @ApiOperation(value = "find", notes = "Find a pc")
    Pc find(@RequestParam("id") Long id) {
        Pc pc = null;
        try {
            pc = pcService.find(id);
        } catch (ItemNotFoundException e) {
            log.info(e.getMessage());
        }
        return pc;
    }

    @PostMapping("add")
    @ApiOperation(value = "add", notes = "Add a pc")
    Pc add(@RequestBody Pc newPc) {
        return pcService.save(newPc);
    }

    @DeleteMapping("delete")
    @ApiOperation(value = "delete", notes = "Delete a pc")
    void delete(@RequestParam("id") Long id) {
        pcService.delete(id);
    }

    @PutMapping("update")
    @ApiOperation(value = "update", notes = "Update a pc or create a new one")
    Pc replaceEmployee(@RequestBody Pc newPc, @RequestParam("id") Long id) {
        return pcService.update(newPc, id);
    }
}
