package com.api_example.controller;

import com.api_example.dto.APIResponse;
import com.api_example.dto.StudentDto;
import com.api_example.dto.UserDto;
import com.api_example.entity.Student;
import com.api_example.entity.User;
import com.api_example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8085/api/v1/user/save
    @PostMapping("/save")
    public ResponseEntity<APIResponse<String>> saveUser(@RequestBody UserDto userDto ){
        userService.saveUser(userDto);
        APIResponse<String > response =new APIResponse<>();
        response.setMessage("record saved..");
        response.setData("done");
        response.setStatus(201);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    //http://localhost:8085/api/v1/user/read
    @GetMapping("/read")
    public ResponseEntity<APIResponse<List<User>>> readStudent(){
         List<User> users = userService.readUser();
        APIResponse<List<User>> response = new APIResponse<>();
        response.setData(users);
        response.setMessage("data found");
        response.setStatus(200);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    //http://localhost:8085/api/v1/user/view?id=1
    @GetMapping("/view")
    public ResponseEntity<APIResponse<User>> readUserById(@RequestParam Long id){
        User user= userService.findById(id);
        APIResponse<User> response = new APIResponse<>();
        response.setMessage("record found..");
        response.setData(user);
        response.setStatus(200);
        return  new ResponseEntity<>(response,HttpStatus.OK);

    }
    //http://localhost:8085/api/v1/user/delete?id=1
    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<String>> deleteUserById(@RequestParam Long id){
        userService.deleteById(id);
        APIResponse<String> response = new APIResponse<>();
        response.setMessage("deleted successfully..");
        response.setData("done");
        response.setStatus(200);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }
    //http://localhost:8085/api/v1/user/update?id=2
    @PutMapping("/update")
    public ResponseEntity<APIResponse<UserDto>> updateUser(@RequestBody UserDto userDto , @RequestParam Long id){
      UserDto usDto= userService.updateUser(userDto, id);
      APIResponse<UserDto> response = new APIResponse<>();
      response.setMessage("record updated..");
      response.setData(usDto);
      response.setStatus(200);
      return  new ResponseEntity<>(response,HttpStatus.OK);



    }






}
