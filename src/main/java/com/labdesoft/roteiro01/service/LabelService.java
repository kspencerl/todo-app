package com.labdesoft.roteiro01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labdesoft.roteiro01.entity.Label;
import com.labdesoft.roteiro01.repository.LabelRepository;

@Service
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;

    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    public Label getLabelByName(String name) {
        return labelRepository.findByName(name);
    }

    public Label addLabel(Label label) {
        return labelRepository.save(label);
    }

    public void deleteLabel(String name) {
        Label label = labelRepository.findByName(name);
        labelRepository.delete(label);
    }
}