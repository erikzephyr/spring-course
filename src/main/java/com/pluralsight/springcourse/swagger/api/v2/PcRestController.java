package com.pluralsight.springcourse.swagger.api.v2;

import com.pluralsight.springcourse.swagger.model.Pc;
import com.pluralsight.springcourse.swagger.services.PcService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Log
@RequestMapping("v2/pcs")
@RestController("PcRestControllerV2")
public class PcRestController {

    @Autowired
    private PcService pcService;

    @GetMapping("all")
    @ApiOperation(value = "all", notes = "Return a list of pc's stored")
    public List<Pc> all() {
        return pcService.all();
    }

}
