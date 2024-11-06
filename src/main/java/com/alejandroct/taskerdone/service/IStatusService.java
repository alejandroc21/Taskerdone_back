package com.alejandroct.taskerdone.service;

import com.alejandroct.taskerdone.dto.StatusDTO;

import java.util.List;

public interface IStatusService {
    List<StatusDTO> listByProjectId(long id);

    StatusDTO findById(long id);

    StatusDTO create(StatusDTO statusDTO);

    List<StatusDTO> createMultiple(List<StatusDTO> statusDTOList);


    StatusDTO update(StatusDTO statusDTO);

    String delete(long id);

}
