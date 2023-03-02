package com.ty.curd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.curd.dto.CurdDto;
import com.ty.curd.service.CurdService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class CurdController {
	
	@Autowired
	private CurdService service;
	
	@GetMapping("/index")
	public ModelAndView getHomePage(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/student-register")
	public ModelAndView getAddSupAdminRegister(ModelAndView modelAndView) {
		modelAndView.setViewName("student-register-form");
		return modelAndView;
	}

	@GetMapping("/student-add")
	public String saveStudent(CurdDto dto, Model myModel) {
		CurdDto cuDto = service.saveStudent(dto);
		if (cuDto != null) {
			return "login";
		} else {
			return "redirect:/student-register-form";
		}
	}
	@PostMapping("/student-login")
	public ModelAndView validate(@RequestParam("studentId") int id, @RequestParam("password") String password,
			HttpServletRequest request, ModelAndView modelAndView, Model model) {
		CurdDto dto=new CurdDto();
		HttpSession session = request.getSession(true);

		if (service.validateLogin(id, password)) {
//			CurdDto student = service.getAllStudent(id);
//			model.addAttribute("Login Success", "student");
			modelAndView.setViewName("student-function-page");
			return modelAndView;
		} 
		else
			modelAndView.setViewName("login");
		return modelAndView;

	}
	
	@GetMapping("/list-all")
	public ModelAndView listAllEmployees(ModelAndView modelAndView, Model model) {
		List<CurdDto> allStudent = service.getAllStudent();
		model.addAttribute("students", allStudent);
		modelAndView.setViewName("displayAll-student");

		return modelAndView;
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("studentId") int id, Model model) {
		CurdDto deletedStudent = service.deleteStudent(id);
		if (deletedStudent == null) {
			return "redirect:/displayAll-student";
		}
		return "forward:/list-all";
	}
	
	@GetMapping("/student-edit")
	public ModelAndView edit(ModelAndView modelAndView) {
		modelAndView.setViewName("search-student");
		return modelAndView;
	}
	@GetMapping("/edit")
	public ModelAndView getEditPage(@RequestParam("studentId")int id,Model model,ModelAndView modelAndView) {
		CurdDto searchedStudent=service.searchTrain(id);
		if(searchedStudent == null) {
			modelAndView.setViewName("search-student");
			return modelAndView;
		}else {
//			model.addAttribute("student", searchedStudent);
			modelAndView.setViewName("edit-student-page");
			return modelAndView;
		}
		
		
		
	}
	
		
//	@GetMapping("/edit/{studentId}")
//	public ModelAndView getEditStudentPage(ModelAndView modelAndView,Model model, @RequestParam("studentId") int id) {
//		CurdDto searchedStudent=service.searchTrain(id);
//		if(searchedStudent == null) {
//			model.addAttribute("msg", "Update Cannot be done because Data not found for tarin number "+id);
//			modelAndView.setViewName("display-student");
//		} else {
//			model.addAttribute("student", searchedStudent);
//			modelAndView.setViewName("edit-student-page");
//		}
//		return modelAndView;
//	}

	@PostMapping("/update-student")
	public String updateTrain(CurdDto dto,ModelAndView modelAndView,@RequestParam("studentId")int id) {
		CurdDto dto1 = service.updateTrain(id,dto);
		return "redirect:/list-all";
		
	}
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, ModelAndView view) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		view.setViewName("index");
		return view;
	}
	

}
