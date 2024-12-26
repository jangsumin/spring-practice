package guestbook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import guestbook.repository.GuestbookRepository;
import guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	private GuestbookRepository guestbookRepository;
	
	public GuestbookController(GuestbookRepository guestbookRepository) {
		this.guestbookRepository = guestbookRepository;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("contents") String contents) {
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setContents(contents);
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		// model.addAttribute("id", id);
		return "delete";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, @RequestParam("password") String password) {
		guestbookRepository.deleteByIdAndPassword(id, password);
		return "redirect:/";
	}
}
