package com.medici.app.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medici.app.spring.model.Advisor;
import com.medici.app.spring.service.AdvisorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author a73s
 *
 */
@RestController
@RequestMapping("/advisor")
@Api(value = "AdvisorResources", consumes = "application/json", produces = "application/json", protocols = "http", description = "Operations Related to Advisor")
public class AdvisorController {

	@Autowired
	private AdvisorService advisorService;

	@GetMapping("/{id}")
	@ApiOperation(consumes = "application/json", produces = "application/json", protocols = "http", value = "getAdvisor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Advisor"),
			@ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
			@ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"), @ApiResponse(code = 404, message = "The resource  not found") })
	public Advisor getAdvisor(@ApiParam("Id of user, Can not be null") @PathVariable int id) throws Exception {
		return advisorService.getAdvisor(id);
	}

	@PostMapping
	@ApiOperation(consumes = "application/json", produces = "application/json", protocols = "http", value = "addAdvisor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Added Advisor"),
			@ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
			@ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"), @ApiResponse(code = 404, message = "The resource  not found") })
	public ResponseEntity addAdvisor(@RequestBody Advisor user) {
		advisorService.addAdvisor(user);
		return new ResponseEntity("Advisor Added successfully", HttpStatus.OK);
	}

	@PutMapping
	@ApiOperation(consumes = "application/json", produces = "application/json", protocols = "http", value = "updateAdvisor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated Advisor"),
			@ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
			@ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"), @ApiResponse(code = 404, message = "The resource  not found") })
	public ResponseEntity updateAdvisor(@RequestBody Advisor user) throws Exception {
		advisorService.updateAdvisor(user);
		return new ResponseEntity("Advisor Updated successfully", HttpStatus.OK);
	}

	@ApiOperation(consumes = "application/json", produces = "application/json", protocols = "http", value = "deleteAdvisor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted Advisor"),
			@ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
			@ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"), @ApiResponse(code = 404, message = "The resource  not found") })
	@DeleteMapping("/{id}")
	public ResponseEntity deleteAdvisor(@PathVariable int id) {
		advisorService.deleteAdvisor(id);
		return new ResponseEntity("Advisor Deleted successfully", HttpStatus.OK);
	}

	@ApiOperation(consumes = "application/json", produces = "application/json", protocols = "http", value = "getAllAdvisors")
	@GetMapping
	public List<Advisor> getAllAdvisors() {
		return advisorService.getAllAdvisors();
	}

}
