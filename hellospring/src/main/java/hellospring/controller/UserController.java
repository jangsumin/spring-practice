package hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping 클래스 + 메서드 매핑
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
		System.out.println(userVo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String no) {
		/**
		 * 만일, n이라는 파라미터 이름이 없거나 값이 바르지 못하면
		 * 400 Bad Request Error 발생
		 */
		return "UserController:update(" + no + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=false) Long no) {
		/**
		 * 파라미터를 받을 때 래퍼 클래스를 쓰는 게 좋다.
		 * 왜냐하면, 기본 자료형과 달리 래퍼 클래스는 null을 허용하므로 파라미터가 전달되지 않은 경우에도 메서드 호출이 가능하다.
		 * 기본 자료형인 int를 사용한 경우에 ?number= 또는 파라미터 미전달 시에 400 Bad Request Error가 발생한다.
		 */
		return "UserController:update2(" + no + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update3")
	public String list(@RequestParam(value="p", required=true, defaultValue="1") int n) {
		return "UserController:update3(" + n  + ")";
	}	
	
}
