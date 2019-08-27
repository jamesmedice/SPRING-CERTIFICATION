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

import com.medici.app.spring.model.Monitor;
import com.medici.app.spring.service.MonitorService;

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
@RequestMapping("/monitor")
@Api(value = "MonitorResources", consumes = "application/json", produces = "application/json", protocols = "http", description = "Operations Related to Monitor")
public class MonitorController {

	@Autowired
	private MonitorService monitorService;

	@GetMapping("/{id}")
	@ApiOperation(consumes = "application/json", produces = "application/json", protocols = "http", value = "getMonitor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Monitor"),
			@ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
			@ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"), @ApiResponse(code = 404, message = "The resource  not found") })
	public Monitor getMonitor(@ApiParam("Id of user, Can not be null") @PathVariable int id) throws Exception {
		return monitorService.getMonitor(id);
	}

	@PostMapping
	@ApiOperation(consumes = "application/json", produces = "application/json", protocols = "http", value = "addMonitor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Added Monitor"),
			@ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
			@ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"), @ApiResponse(code = 404, message = "The resource  not found") })
	public ResponseEntity addMonitor(@RequestBody Monitor user) {
		monitorService.addMonitor(user);
		return new ResponseEntity("Monitor Added successfully", HttpStatus.OK);
	}

	@PutMapping
	@ApiOperation(consumes = "application/json", produces = "application/json", protocols = "http", value = "updateMonitor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated Monitor"),
			@ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
			@ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"), @ApiResponse(code = 404, message = "The resource  not found") })
	public ResponseEntity updateMonitor(@RequestBody Monitor user) throws Exception {
		monitorService.updateMonitor(user);
		return new ResponseEntity("Monitor Updated successfully", HttpStatus.OK);
	}

	@ApiOperation(consumes = "application/json", produces = "application/json", protocols = "http", value = "deleteMonitor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted Monitor"),
			@ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
			@ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"), @ApiResponse(code = 404, message = "The resource  not found") })
	@DeleteMapping("/{id}")
	public ResponseEntity deleteMonitor(@PathVariable int id) {
		monitorService.deleteMonitor(id);
		return new ResponseEntity("Monitor Deleted successfully", HttpStatus.OK);
	}

	@ApiOperation(consumes = "application/json", produces = "application/json", protocols = "http", value = "getAllMonitors")
	@GetMapping
	public List<Monitor> getAllMonitors() {
		return monitorService.getAllMonitors();
	}

}
