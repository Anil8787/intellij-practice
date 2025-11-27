package com.api_example.service;

import com.api_example.dto.StudentDto;
import com.api_example.entity.Student;
import com.api_example.entity.StudentAddress;
import com.api_example.exception.ResourceNotFound;
import com.api_example.repository.StudentAddressRepository;
import com.api_example.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private StudentAddressRepository studentAddressRepository;

    public StudentService(StudentRepository studentRepository, StudentAddressRepository studentAddressRepository) {
        this.studentRepository = studentRepository;
        this.studentAddressRepository = studentAddressRepository;
    }


    public String saveStudentData(StudentDto studentDto) {
        Student s = new Student();
        BeanUtils.copyProperties(studentDto, s);
        //studentRepository.save(s);

        StudentAddress add = new StudentAddress();
        BeanUtils.copyProperties(studentDto, add);
        //studentAddressRepository.save(add);
        add.setStudent(s);
        s.setStudentAddress(add);
        try {
            studentRepository.save(s);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
            return "done";
    }


    public List<Student> readStudents() {
        List<Student> all = studentRepository.findAll();
        return all;

    }

    public void deleteById(Long id) {
        studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("record not found with id:" + id)
        );
        studentRepository.deleteById(id);
    }

    public Student findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("record does not exists.")
        );
        return student;
    }
    //here you perform update by id.
    public StudentDto updateStudentById(StudentDto studentDto, Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("no record exist with  id:" +id)
        );
        student.setName(studentDto.getName());
        student.setMobile(studentDto.getMobile());
        student.setEmail(studentDto.getEmail());

        Student save = studentRepository.save(student);
        StudentDto stuDto = new StudentDto();
        BeanUtils.copyProperties(save, stuDto);
        return stuDto;
    }

}
