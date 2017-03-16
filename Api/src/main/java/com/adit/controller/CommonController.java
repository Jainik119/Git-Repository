package com.adit.controller;

import com.adit.delegetor.CommonDelegetor;
import com.adit.entity.Country;
import com.adit.entity.State;
import com.adit.entity.rest.RestResponse;
import com.adit.util.AppConstatnt;
import com.adit.util.RestApiConstantURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jainik.bakaraniya on 3/14/2017.
 */
@RestController
@RequestMapping
public class CommonController {

    @Autowired
    private CommonDelegetor commonDelegetor;

    @RequestMapping(value = RestApiConstantURL.SAVE_COUNTRY, method = RequestMethod.POST, headers = AppConstatnt.HEADERS_ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> createCountry(HttpEntity<Country> httpEntity) {

        RestResponse restResponse = new RestResponse();
        Country country = httpEntity.getBody();
        try {
            if (country.getId() == 0) {
                country.setCountryName(country.getCountryName());
                commonDelegetor.addCountry(country);
                restResponse.setSuccessMessage(AppConstatnt.MESSAGE_SUCESS_ADD);
            } else {
                commonDelegetor.updateCountry(country);
                restResponse.setSuccessMessage(AppConstatnt.MESSAGE_SUCESS_UPDATE);
            }
            return new ResponseEntity<>(restResponse, HttpStatus.OK);
        } catch (Exception ex) {
            restResponse.setErrorMessage(ex.getMessage());
            return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = RestApiConstantURL.DELETE_COUNTRY, method = RequestMethod.DELETE, headers = AppConstatnt.HEADERS_ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> deleteCountry(@PathVariable("id") Long id) {
        try {
            commonDelegetor.deleteCountry(id);
            RestResponse restResponse = new RestResponse();
            restResponse.setSuccessMessage(AppConstatnt.MESSAGE_SUCESS_DELETE);
            return new ResponseEntity<>(restResponse, HttpStatus.OK);
        } catch (Exception ex) {
            RestResponse restResponse = new RestResponse();
            restResponse.setErrorMessage(ex.getMessage());
            return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = RestApiConstantURL.FIND_ALL_COUNTRY, method = RequestMethod.GET, headers = AppConstatnt.HEADERS_ACCEPT_JSON)
    public ResponseEntity<Map<String, Object>> getAllCountry() {
        Map<String, Object> data = new HashMap<>();
        List<Country> list = commonDelegetor.getAllCountry();
        data.put(AppConstatnt.RESPONSE, AppConstatnt.RESPONSE_TRUE);
        data.put(AppConstatnt.DATA, list);
        return ResponseEntity.ok(data);
    }

    @RequestMapping(value = RestApiConstantURL.FIND_ONE_COUNTRY, method = RequestMethod.GET, headers = AppConstatnt.HEADERS_ACCEPT_JSON)
    public ResponseEntity<Map<String, Object>> getCountryById(@PathVariable("id") Long id) {
        Map<String, Object> data = new HashMap<>();
        Country country = commonDelegetor.getCountryById(id);
        data.put(AppConstatnt.RESPONSE, AppConstatnt.RESPONSE_TRUE);
        data.put(AppConstatnt.DATA, country);
        return ResponseEntity.ok(data);
    }


    @RequestMapping(value = RestApiConstantURL.SAVE_STATE, method = RequestMethod.POST, headers = AppConstatnt.HEADERS_ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> createState(HttpEntity<State> httpEntity) {

        RestResponse restResponse = new RestResponse();
        State state = httpEntity.getBody();
        try {
            if (state.getId() == 0) {
                state.setStateName(state.getStateName());
                state.setCountry(state.getCountry());
                commonDelegetor.addState(state);
                restResponse.setSuccessMessage(AppConstatnt.MESSAGE_SUCESS_ADD);
            } else {
                commonDelegetor.updateState(state);
                restResponse.setSuccessMessage(AppConstatnt.MESSAGE_SUCESS_UPDATE);
            }
            return new ResponseEntity<>(restResponse, HttpStatus.OK);
        } catch (Exception ex) {
            restResponse.setErrorMessage(ex.getMessage());
            return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = RestApiConstantURL.DELETE_STATE, method = RequestMethod.DELETE, headers = AppConstatnt.HEADERS_ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> deleteState(@PathVariable("id") Long id) {
        try {
            commonDelegetor.deleteState(id);
            RestResponse restResponse = new RestResponse();
            restResponse.setSuccessMessage(AppConstatnt.MESSAGE_SUCESS_DELETE);
            return new ResponseEntity<>(restResponse, HttpStatus.OK);
        } catch (Exception ex) {
            RestResponse restResponse = new RestResponse();
            restResponse.setErrorMessage(ex.getMessage());
            return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = RestApiConstantURL.FIND_ALL_STATE, method = RequestMethod.GET, headers = AppConstatnt.HEADERS_ACCEPT_JSON)
    public ResponseEntity<Map<String, Object>> getAllState() {
        Map<String, Object> data = new HashMap<>();
        List<State> list = commonDelegetor.getAllState();
        data.put(AppConstatnt.RESPONSE, AppConstatnt.RESPONSE_TRUE);
        data.put(AppConstatnt.DATA, list);
        return ResponseEntity.ok(data);
    }

    @RequestMapping(value = RestApiConstantURL.FIND_ONE_STATE, method = RequestMethod.GET, headers = AppConstatnt.HEADERS_ACCEPT_JSON)
    public ResponseEntity<Map<String, Object>> getStateById(@PathVariable("id") Long id) {
        Map<String, Object> data = new HashMap<>();
        State state = commonDelegetor.getStateById(id);
        data.put(AppConstatnt.RESPONSE, AppConstatnt.RESPONSE_TRUE);
        data.put(AppConstatnt.DATA, state);
        return ResponseEntity.ok(data);
    }
}
