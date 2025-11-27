package com.api_example.service;

import com.api_example.dto.RailwayDto;
import com.api_example.entity.Railway;
import com.api_example.repository.RailwayRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RailwayService {

    private RailwayRepository railwayRepository;


    public void saveRailway(RailwayDto railwayDto) {
        Railway railway = new Railway();
        BeanUtils.copyProperties(railwayDto,railway);
        railwayRepository.save(railway);

    }


    public List<Railway> findAllRailway() {
        List<Railway> all = railwayRepository.findAll();
        return all;
    }
}
