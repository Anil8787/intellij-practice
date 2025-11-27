package com.api_example.controller;

import com.api_example.dto.APIResponse;
import com.api_example.dto.RailwayDto;
import com.api_example.entity.Railway;
import com.api_example.service.RailwayService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/railway")
public class RailwayController {

    private RailwayService railwayService;

    //http://localhost:8085/api/v1/railway/save
    @PostMapping("/save")
    public ResponseEntity<APIResponse<String>> saveRailway(@RequestBody RailwayDto railwayDto){
        railwayService.saveRailway(railwayDto);
        APIResponse<String> response =new APIResponse<>();
        response.setMessage("Done!");
        response.setData("record saved Successfully..");
        response.setStatus(201);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    //http://localhost:8085/api/v1/railway/findAll
    @GetMapping("/findAll")
    public ResponseEntity<APIResponse<List<Railway>>> findAllRailway(){
          List<Railway> railways = railwayService.findAllRailway();
          APIResponse<List<Railway>> response = new APIResponse<>();
          response.setMessage("found All.");
          response.setData(railways);
          response.setStatus(200);
          return new ResponseEntity<>(response,HttpStatus.OK);
    }



}
