package com.backend.demo.controller.applyController;

import com.backend.demo.model.Apply;
import com.backend.demo.service.apply.ApplyCreateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/matchings")
@CrossOrigin("*")
@Api(value="API REST CREATE APPLICATION")
public class applyCreateController {
    @Autowired
    private ApplyCreateService applyCreateService;

    @ApiOperation(value="should create applications")
    @PostMapping(path = "create")
    public ResponseEntity<Object> Create(@Valid @RequestBody Apply request) {
        return this.applyCreateService.create(request);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
