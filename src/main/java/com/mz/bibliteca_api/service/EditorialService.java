package com.mz.bibliteca_api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.bibliteca_api.entity.Editorial;
import com.mz.bibliteca_api.iservice.IEditorialService;
import com.mz.bibliteca_api.repository.EditorialRepository;

@Service
public class EditorialService implements IEditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public List<Editorial> findAll() {
        return editorialRepository.findAll();
    }

    @Override
    public Editorial save(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    @Override
    public Optional<Editorial> findById(Integer id) {
        return editorialRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        editorialRepository.deleteById(id);
    }
}