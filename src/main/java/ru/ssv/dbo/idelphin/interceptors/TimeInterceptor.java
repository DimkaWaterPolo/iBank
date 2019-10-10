package ru.ssv.dbo.idelphin.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * TimeInterceptor - Interceptor, измеряющий время работы обработчика запроса
 * @author Scheglov
 *
 */

public class TimeInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
								HttpServletResponse response,
									Object handler) throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
							HttpServletResponse response, 
								Object handler,
									ModelAndView modelAndView) throws Exception {
		
		long startTime = Long.valueOf(request.getAttribute("startTime").toString());
		long delay = System.currentTimeMillis() - startTime;
		logger.info("Выполнение метода контроллера " + handler + " составила " + delay + " миллисек.");
	}

}
