package com.hcl.sandwich.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hcl.sandwich.dto.ApiExceptionDto;
import com.hcl.sandwich.dto.ResponseDto;
import com.hcl.sandwich.util.ApiConstant;
import com.hcl.sandwich.util.ApplicationConstants;
import com.hcl.sandwich.util.LibraryUtil;



@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * @author Shankar This method is used to handle all runtime exception
	 *
	 * @param exection
	 * @return ApiExceptionDto with message
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public final ApiExceptionDto handleAllRuntimeExceptions(RuntimeException exection) {
		String defaultMessage = exection.getMessage();
		return new ApiExceptionDto(ApiConstant.INTERNAL_SERVER_ERROR, defaultMessage);
	}

	/**
	 * @author Shankar This method is used to handle all exception
	 *
	 * @param exection
	 * @return ApiExceptionDto with message
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public final ApiExceptionDto handleAllExceptions(Exception exection) {
		String defaultMessage = exection.getMessage();
		return new ApiExceptionDto(ApiConstant.INTERNAL_SERVER_ERROR, defaultMessage);
	}

	/**
	 * @author Shankar This method is used to handle all null pointer exception
	 *
	 * @param exection
	 * @return ApiExceptionDto with message
	 */
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public final ApiExceptionDto handleNullPointerExceptions(NullPointerException exection) {
		String defaultMessage = exection.getMessage();
		return new ApiExceptionDto(ApiConstant.NO_ELEMENT_FOUND, defaultMessage);
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseDto> DataNotFoundException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(LibraryUtil.NO_ITEM_SELECTED);
		responseDto.setStatusCode(ApplicationConstants.NOTFOUND_CODE);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
	}

	@ExceptionHandler(NoItemsArePresentException.class)
    public ResponseEntity<ErrorResponse> noItemsArePresentException(NoItemsArePresentException ex) {
        
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessgage(ex.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setDateAndTime(LocalDateTime.now());
		
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}