package com.adit.controller.rest;

import com.adit.entity.rest.RestResponse;
import com.adit.util.AppConstatnt;
import com.adit.util.RestApiConstantURL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jainik.bakaraniya on 3/10/2017.
 */

@RestController
public class ApplicationTestController {

    @RequestMapping(value = RestApiConstantURL.API_TEST_URL, method = RequestMethod.GET, headers = AppConstatnt.HEADERS_ACCEPT_JSON)
    public ResponseEntity<RestResponse> testApi(){
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccessMessage(AppConstatnt.API_RUNNING_FINE);
        return new ResponseEntity<>(restResponse, HttpStatus.OK);
    }
}
