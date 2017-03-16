package com.adit.repository;

import com.adit.entity.Country;
import com.adit.entity.State;
import com.adit.util.CastListElements;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jainik.bakaraniya on 3/14/2017.
 */
@Repository
@Transactional
public class CommonRepositoryImpl implements CommonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCountry(Country country) {
        getSession().save(country);
        getSession().flush();
    }

    @Override
    public void updateCountry(Country country) {
        getSession().update(country);
    }

    @Override
    public void deleteCountry(Long id) {
    getSession().delete(getCountryById(id));
    }

    @Override
    public Country getCountryById(Long id) {
        Criteria criteria = getSession().createCriteria(Country.class);
        criteria.add(Restrictions.eq("id", id));
        return (Country)criteria.uniqueResult();
    }

    @Override
    public List<Country> getAllCountry() {
        Criteria criteria = getSession().createCriteria(Country.class);
        return CastListElements.castList(Country.class, criteria.list());
    }

    @Override
    public void addState(State state) {
        getSession().save(state);
        getSession().flush();
    }

    @Override
    public void updateState(State state) {
        getSession().update(state);
    }

    @Override
    public void deleteState(Long id) {
        getSession().delete(getStateById(id));
    }

    @Override
    public State getStateById(Long id) {
        Criteria criteria = getSession().createCriteria(State.class);
        criteria.add(Restrictions.eq("id",id));
        return (State) criteria.uniqueResult();
    }

    @Override
    public List<State> getAllState() {
        Criteria criteria = getSession().createCriteria(State.class);
        return CastListElements.castList(State.class, criteria.list());
    }
}
