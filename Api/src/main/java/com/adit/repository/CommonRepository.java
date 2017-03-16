package com.adit.repository;

import com.adit.entity.Country;
import com.adit.entity.State;

import java.util.List;

/**
 * Created by jainik.bakaraniya on 3/14/2017.
 */
public interface CommonRepository {

    public void addCountry(Country country);
    public void updateCountry(Country country);
    public void deleteCountry(Long id);
    public Country getCountryById(Long id);
    public List<Country> getAllCountry();

    public void addState(State state);
    public void updateState(State state);
    public void deleteState(Long id);
    public State getStateById(Long id);
    public List<State> getAllState();
}
