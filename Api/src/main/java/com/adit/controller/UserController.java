package com.adit.controller;

import com.adit.delegetor.UserDelegetor;
import com.adit.entity.User;
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

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserDelegetor userDelegator;

	@RequestMapping(value = RestApiConstantURL.SAVE_USER, method = RequestMethod.POST, headers = AppConstatnt.HEADERS_ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> create(HttpEntity<User> httpEntity) {

		RestResponse restResponse = new RestResponse();
		User user = httpEntity.getBody();
		try {
			if (user.getId() == 0) {
				user.setFirstName(user.getFirstName());
				user.setLastName(user.getLastName());
				user.setEmail(user.getEmail());
				user.setRole(user.getRole());
				user.setStatus(user.getStatus());
				user.setContactNumber(user.getContactNumber());
				user.setDob(user.getDob());
				userDelegator.add(user);
				restResponse.setSuccessMessage(AppConstatnt.MESSAGE_SUCESS_ADD);
			} else {
				userDelegator.update(user);
				restResponse.setSuccessMessage(AppConstatnt.MESSAGE_SUCESS_UPDATE);
			}
			return new ResponseEntity<>(restResponse, HttpStatus.OK);
		} catch (Exception ex) {
			restResponse.setErrorMessage(ex.getMessage());
			return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = RestApiConstantURL.DELETE_USER, method = RequestMethod.DELETE, headers = AppConstatnt.HEADERS_ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> delete(@PathVariable("id") long id) {
		try {
			userDelegator.delete(id);
			RestResponse restResponse = new RestResponse();
			restResponse.setSuccessMessage(AppConstatnt.MESSAGE_SUCESS_DELETE);
			return new ResponseEntity<>(restResponse, HttpStatus.OK);
		} catch (Exception ex) {
			RestResponse restResponse = new RestResponse();
			restResponse.setErrorMessage(ex.getMessage());
			return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = RestApiConstantURL.FIND_ALL_USER, method = RequestMethod.GET, headers = AppConstatnt.HEADERS_ACCEPT_JSON)
	public ResponseEntity<Map<String, Object>> findAll() {
		Map<String, Object> data = new HashMap<>();
		List<User> list = userDelegator.findAll();


		data.put(AppConstatnt.RESPONSE, AppConstatnt.RESPONSE_TRUE);
		data.put(AppConstatnt.DATA, list);
		return ResponseEntity.ok(data);
	}

	@RequestMapping(value = RestApiConstantURL.FIND_ONE_USER, method = RequestMethod.GET, headers = AppConstatnt.HEADERS_ACCEPT_JSON)
	public ResponseEntity<Map<String, Object>> getUserById(@PathVariable("id") long id) {
		Map<String, Object> data = new HashMap<>();
		User user = userDelegator.getById(id);
		data.put(AppConstatnt.RESPONSE, AppConstatnt.RESPONSE_TRUE);
		data.put(AppConstatnt.DATA, user);
		return ResponseEntity.ok(data);
	}
}
