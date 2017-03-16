package com.adit.service;

import com.adit.entity.Country;
import com.adit.entity.State;
import com.adit.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jainik.bakaraniya on 3/14/2017.
 */
@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    private CommonRepository commonRepository;


    @Override
    public void addCountry(Country country) {
        commonRepository.addCountry(country);
    }

    @Override
    public void updateCountry(Country country) {
        commonRepository.updateCountry(country);
    }

    @Override
    public void deleteCountry(Long id) {
        commonRepository.deleteCountry(id);
    }

    @Override
    public Country getCountryById(Long id) {
        return commonRepository.getCountryById(id);
    }

    @Override
    public List<Country> getAllCountry() {
        return commonRepository.getAllCountry();
    }

    @Override
    public void addState(State state) {
        commonRepository.addState(state);
    }

    @Override
    public void updateState(State state) {
        commonRepository.updateState(state);
    }

    @Override
    public void deleteState(Long id) {
        commonRepository.deleteState(id);
    }

    @Override
    public State getstateById(Long id) {
       return commonRepository.getStateById(id);
    }

    @Override
    public List<State> getAllState() {
        return commonRepository.getAllState();
    }
}
