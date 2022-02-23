package LHU.project.service.impl;

import LHU.project.repository.CreatorRepository;
import LHU.project.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorServiceImpl implements CreatorService {

    @Autowired
    private CreatorRepository creatorRepository;

    @Override
    public List<Creator> getAllCreator() {
        return creatorRepository.getAllCreator();
    }
}
