package com.api_example.service;

import com.api_example.dto.CoachDto;
import com.api_example.entity.Coach;
import com.api_example.repository.CoachReposiitory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    private CoachReposiitory coachReposiitory;

    public CoachService(CoachReposiitory coachReposiitory) {
        this.coachReposiitory = coachReposiitory;
    }

    public void saveCoach(CoachDto coachDto) {
        Coach coach = new Coach();
        BeanUtils.copyProperties(coachDto,coach);
        coachReposiitory.save(coach);
    }

    public List<Coach> readAllCoach() {
       return coachReposiitory.findAll();
    }

    public Coach findCoachById(Long id) {
        return  coachReposiitory.findById(id).get();
    }


    public void deleteCoachById(Long id) {
        coachReposiitory.deleteById(id);

    }

    public CoachDto updateCoach(CoachDto coachDto, Long id) {
        Coach coach = coachReposiitory.findById(id).get();
        BeanUtils.copyProperties(coachDto,coach);
        coachReposiitory.save(coach);
        CoachDto chDto = new CoachDto();
        BeanUtils.copyProperties(coach ,chDto);
        return chDto;
    }
}
