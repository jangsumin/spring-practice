package emaillist03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import emaillist03.repository.EmaillistRepository;
import emaillist03.vo.EmaillistVo;

@Controller
public class EmaillistController {
	private EmaillistRepository emaillistRepository;
	
	public EmaillistController(EmaillistRepository emaillistRepository) {
		this.emaillistRepository = emaillistRepository;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		// 직접 DAO 객체를 만드는 순간, 컨트롤러와의 강한 결합이 생긴다.
		// List list = new EmaillistRepository().findAll();
		
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("/add")
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
}
