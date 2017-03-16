package com.adit.delegetor;

import com.adit.entity.Country;
import com.adit.entity.State;
import com.adit.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jainik.bakaraniya on 3/14/2017.
 */

@Component
public class CommonDelegetor{

    @Autowired
    private CommonService commonService;


    public void addCountry(Country country) {
        commonService.addCountry(country);
    }

    public void updateCountry(Country country) {
        commonService.updateCountry(country);
    }

    public void deleteCountry(Long id) {
        commonService.deleteCountry(id);
    }

    public Country getCountryById(Long id) {
        return commonService.getCountryById(id);
    }

    public List<Country> getAllCountry() {
        return commonService.getAllCountry();
    }

    public void addState(State state) {
        commonService.addState(state);
    }

    public void updateState(State state) {
        commonService.updateState(state);
    }

    public void deleteState(Long id) {
        commonService.deleteState(id);
    }

    public State getStateById(Long id) {
       return commonService.getstateById(id);
    }

    public List<State> getAllState() {
        return commonService.getAllState();
    }
}
