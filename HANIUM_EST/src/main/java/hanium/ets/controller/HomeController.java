package hanium.ets.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}
	
	/**
	 * 에러페이지 처리
	 * @param request 에러메세지를 담기 위함
	 */
	@RequestMapping("/error")
	public ModelAndView error(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.addObject("errorMessage", request.getAttribute("errorMessage"));
		mv.setViewName("/error/error");
		return mv;
	}
	
}
