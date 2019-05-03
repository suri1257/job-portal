package com.intellect.jobportal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.jobportal.enums.ErrorMessages;
import com.intellect.jobportal.exception.BaseException;
import com.intellect.jobportal.model.AdditionalInfo;
import com.intellect.jobportal.model.AdditionalInfoRequest;
import com.intellect.jobportal.model.Address;
import com.intellect.jobportal.model.Organization;
import com.intellect.jobportal.model.User;
import com.intellect.jobportal.model.UserRequest;
import com.intellect.jobportal.model.UserResponse;
import com.intellect.jobportal.model.common.BaseResponse;
import com.intellect.jobportal.model.common.CommonResponse;
import com.intellect.jobportal.repository.UserRepository;
import com.intellect.jobportal.utils.Utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = {"user"})
@Api(value ="onlineJobportal", description = "This is job portal for job application" )
public class JobPortalController {

	@Autowired UserRepository repository;
	

	@RequestMapping(value = {"ping","call"}, method = {RequestMethod.GET})
	public ResponseEntity<?> ping( ) {
		User user = new User();
		Address address = new Address();
		AdditionalInfo additionalInfo = new AdditionalInfo();
		Organization organization = new Organization();
		organization.setName("Intl");
		List<Organization> organizations = new ArrayList<>();
		organizations.add(organization);
		additionalInfo.setOrganizations(organizations);
		address.setLine1("ss");
		user.setAddress(address);
		user.setAdditionalInfo(additionalInfo);
		UserResponse userResponse = new UserResponse();
		userResponse.setUser(user);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"register"}, method = {RequestMethod.POST, RequestMethod.PUT})
	@ApiOperation(value = "portal Registration",response = UserResponse.class, notes="In this job portal this service is used to register purpose")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Registered"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	public ResponseEntity<?> createUser( @RequestBody UserRequest userRequest) {
		User user = userRequest.getUser();
		if(null == user.getId() ) {
			user.setId( new ObjectId( new Date()).toString());
		}
		User save = repository.save(user);
		UserResponse response = new UserResponse();
		response.setUser(save);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"userinfo/{id}"}, method = {RequestMethod.GET})
	public ResponseEntity<?> userInfo( @PathVariable("id") String id ) {
		User user = repository.findOne(id);
		if( Utils.isEmpty(user )) {
			throw new BaseException(ErrorMessages.DATA_NOT_FOUND, "200" );
		}
		UserResponse response = new UserResponse();
		response.setUser(user);	
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@RequestMapping(value = {"users/{id}"}, method = {RequestMethod.GET})
	public ResponseEntity<?> users( @PathVariable("id") String id ) {
		checkUser(id);
		List<User> users = repository.findAll();
		Stream<User> stream = users.stream();
		 List<User> applicants = stream.filter(user -> user.getRole().equalsIgnoreCase("APPLICANT") ).collect( Collectors.toList() );
		CommonResponse<User> commonResponse = new CommonResponse<>();
		commonResponse.setList( applicants);	
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"{id}/additionalInfo"}, method = {RequestMethod.POST,RequestMethod.PUT})
	public ResponseEntity<?> additionalInfo( @PathVariable("id") String id, @RequestBody AdditionalInfoRequest additionalInfoRequest ) {
		AdditionalInfo additionalInfo = additionalInfoRequest.getAdditionalInfo();
		User user = repository.findOne(id);
		if( Utils.isEmpty(user )) {
			throw new BaseException(ErrorMessages.DATA_NOT_FOUND, "200" );
		}
		
		List<String> techExpertise = additionalInfo.getTechExpertise().stream().map( s -> s.toUpperCase() ).collect(Collectors.toList());
		additionalInfo.setTechExpertise(techExpertise);
		user.setAdditionalInfo(additionalInfo);
		User save = repository.save(user);
		BaseResponse baseResponse = successResponse();
		return new ResponseEntity<>( baseResponse, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = {"{id}/search/{criteria}"}, method = {RequestMethod.GET})
	public ResponseEntity<?> search( @PathVariable("id") String id, @PathVariable("criteria") String criteria ) {
		checkUser(id);
		List<User> users = repository.findAll();
		Stream<User> stream = users.stream();
		List<User> applicants = stream.filter( user -> user.getRole().equalsIgnoreCase("APPLICANT") && Utils.isNotEmpty( user.getAdditionalInfo() ) && user.getAdditionalInfo().getTechExpertise().contains(criteria) ).collect( Collectors.toList() );
		CommonResponse<User> commonResponse = new CommonResponse<>();
		commonResponse.setList( applicants);
		commonResponse.setCount(applicants.size());
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	private BaseResponse  successResponse() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus("Success");
		baseResponse.setCode("200");
		baseResponse.setMessage("Operation done successfully!");
		return baseResponse;
	}
	
	private boolean checkUser(String id) {
		User user = repository.findOne(id);
		if( Utils.isEmpty(user )) {
			throw new BaseException(ErrorMessages.DATA_NOT_FOUND, "200" );
		}
		return true;
	}
	
}
