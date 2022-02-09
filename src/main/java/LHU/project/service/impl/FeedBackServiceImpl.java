package LHU.project.service.impl;

import LHU.project.entities.FeedBack;
import LHU.project.repository.FeedBackRepository;
import LHU.project.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    @Override
    public FeedBack saveOrUpdate(FeedBack feedBack) {
        return feedBackRepository.save(feedBack);
    }
}
