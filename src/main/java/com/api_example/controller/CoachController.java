package com.api_example.controller;

import com.api_example.dto.APIResponse;
import com.api_example.dto.CoachDto;
import com.api_example.dto.EmployeeDto;
import com.api_example.entity.Coach;
import com.api_example.service.CoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coach")
public class CoachController {

    private CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    //http://localhost:8085/api/v1/coach/save
    @PostMapping("/save")
    public ResponseEntity<APIResponse<String>> saveCoach(@RequestBody CoachDto coachDto){
        coachService.saveCoach(coachDto);
        APIResponse<String> response = new APIResponse<>();
        response.setMessage("done!");
        response.setData("data saved");
        response.setStatus(201);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    //http://localhost:8085/api/v1/coach/read
    @GetMapping("/read")
    public ResponseEntity<APIResponse<List<Coach>>> readAllCoach(){
        List<Coach> coaches = coachService.readAllCoach();
        APIResponse<List<Coach>> response = new APIResponse<>();
        response.setMessage("found all coach");
        response.setData(coaches);
        response.setStatus(200);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }

    //http://localhost:8085/api/v1/coach/find?id=1
    @GetMapping("/find")
    public ResponseEntity<APIResponse<Coach>> findCoachById(@RequestParam Long id){
        Coach coach= coachService.findCoachById(id);
        APIResponse<Coach> response = new APIResponse<>();
        response.setMessage("foundById");
        response.setData(coach);
        response.setStatus(200);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }
    //http://localhost:8085/api/v1/coach/delete?id=1
    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<String>> deleteCoach(@RequestParam Long id){
        coachService.deleteCoachById(id);
        APIResponse<String> response = new APIResponse<>();
        response.setMessage("done!");
        response.setData("deleted successfully");
        response.setStatus(200);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }

    //http://localhost:8085/api/v1/coach/update?id=2
    @PutMapping("/update")
    public ResponseEntity<APIResponse<CoachDto>> updateCoach(@RequestBody CoachDto coachDto ,@RequestParam Long id){
        CoachDto cochDto = coachService.updateCoach(coachDto,id);
        APIResponse<CoachDto> response= new APIResponse<>();
        response.setData(cochDto);
        response.setMessage("updated Successfully");
        response.setStatus(200);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }




}
