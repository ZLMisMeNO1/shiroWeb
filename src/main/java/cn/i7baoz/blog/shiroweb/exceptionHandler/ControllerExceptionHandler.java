package cn.i7baoz.blog.shiroweb.exceptionHandler;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;

import cn.i7baoz.blog.shiroweb.dto.ResultMap;
import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-12
 * <p>Version: 1.0
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	
	private static final Logger logger = Logger.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultMap<String> processUnauthenticatedException(NativeWebRequest request, AuthenticationException e) {
    	return new ResultMap<String>(e);
    }
    
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultMap<String> noRoleOrPermission(NativeWebRequest request, UnauthorizedException e) {
    	logger.info("current user do not has role or permission");
    	return new ResultMap<String>(SystemMessageEnum.USER_HAS_NO_PERMISSION);
    }
    

}
