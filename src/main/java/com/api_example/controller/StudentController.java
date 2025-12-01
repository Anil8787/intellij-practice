package com.api_example.controller;

import com.api_example.dto.APIResponse;
import com.api_example.dto.StudentDto;
import com.api_example.entity.Student;
import com.api_example.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //http://localhost:8085/api/v1/student/save
    @PostMapping("/save")
    public ResponseEntity<APIResponse<?>> saveStudent(@RequestBody StudentDto studentDto){
        String s = studentService.saveStudentData(studentDto);
        if (s != null){
            APIResponse<String> res = new APIResponse<>();
            res.setMessage("data saved successfully");
            res.setData("done");
            res.setStatus(201);
            return new ResponseEntity<>(res ,HttpStatus.CREATED);
        }else{
            APIResponse<String> res = new APIResponse<>();
            res.setMessage("done");
            res.setData("duplicate entry..");
            res.setStatus(201);
            return new ResponseEntity<>(res ,HttpStatus.CREATED);
        }

    }

    //http://localhost:8085/api/v1/student/read?pageNo=0&pageSize=6
    @GetMapping("/read")
    public ResponseEntity<APIResponse<List<Student>>> readStudent(
            @RequestParam(name="pageNo",required = false,defaultValue = "0") int pageNo ,
            @RequestParam(name="pageSize",required = false ,defaultValue = "3") int pageSize,
            @RequestParam(name="description",required = false ,defaultValue = "asc") String description
    ){
       List<Student> students= studentService.readStudents(pageNo,pageSize,description);
       APIResponse<List<Student>> student = new APIResponse<>();
       student.setData(students);
       student.setMessage("all data ");
       student.setStatus(200);
         return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //http://localhost:8085/api/v1/student/delete?id=
    @DeleteMapping("delete")
    public ResponseEntity<APIResponse<String>> deleteStudentById(@RequestParam Long id){
        studentService.deleteById(id);
        APIResponse<String> stud = new APIResponse<>();
        stud.setMessage("deleted successfully");
        stud.setData("deleted");
        stud.setStatus(200);
        return new ResponseEntity<>(stud,HttpStatus.OK);
    }
    //http://localhost:8085/api/v1/student/find?id=
    @GetMapping("/find")
    public ResponseEntity<APIResponse<Student>> findStudentById(@RequestParam Long id){
        Student byId = studentService.findById(id);
        APIResponse<Student> stud = new APIResponse<>();
        stud.setMessage("find by id");
        stud.setData(byId);
        stud.setStatus(200);
        return new ResponseEntity<>(stud,HttpStatus.OK);

    }
    //http://localhost:8085/api/v1/student/update?id=
    @PutMapping("/update")
    public ResponseEntity<APIResponse<StudentDto>> updateStudent(@RequestBody StudentDto studentDto , @RequestParam Long id){
         StudentDto stuDto = studentService.updateStudentById(studentDto,id);
         APIResponse<StudentDto> stu = new APIResponse<>();
         stu.setMessage("updated successfully..");
         stu.setData(stuDto);
         stu.setStatus(200);
         return new ResponseEntity<>(stu,HttpStatus.OK);

    }

}
