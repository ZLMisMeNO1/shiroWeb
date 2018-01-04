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
import org.springframework.web.servlet.ModelAndView;

import cn.i7baoz.blog.shiroweb.status.CurrentStatus;
import cn.i7baoz.blog.shiroweb.util.ResultMap;

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
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, AuthenticationException e) {
    	logger.info("catch exception");
    	logger.info(e.getMessage());
    	return null;
    }
    
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultMap<String> noRoleOrPermission(NativeWebRequest request, UnauthorizedException e) {
    	logger.info("current user do not has role or permission");
    	return new ResultMap<String>(CurrentStatus.NOT_HAS_ROLE_OR_PERMISSION);
    }
    

}
