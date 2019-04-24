package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.model.Student;
import com.cjc.service.ServiceInterface;

@Controller
public class MainController {
	@Autowired
	private ServiceInterface service;

	@RequestMapping("/")
	public String preLogin() {
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logOut() {
		return "index";
	}

	@RequestMapping("/register")
	public String registerStudent() {
		return "register";
	}

	@RequestMapping(value = "/regi", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student s) {
		
		int id;
		if (s.getRollno() == 0) {
		id = service.registerUser(s);
        } else {
        id = service.updateStudent(s);
        }
		if (id>0) {
			return "index";
		} else {
			return "register";
		}
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displayStudent(@RequestParam String uname,@RequestParam String pass, Model m){
		
		if(uname.equals("admin")&&pass.equals("admin")) {
			m.addAttribute("data",service.getAllStudent());
			return "success";
		}
		else
		{
			List<Student> listStudent = service.getStudent(uname,pass);
			if(listStudent!=null)
			{
				m.addAttribute("data",listStudent);
				return "success";
			}
			else
			{
				m.addAttribute("msg", "Please Enter Proper Credential");
				return "login";
			}
		}
	}
		@RequestMapping("/delete")
	    public String removeStudent(@RequestParam int id, Model m) {
	        service.deleteStudent(id);
	        m.addAttribute("data", service.getAllStudent()); 
	        return "success";
	    }
		
		@RequestMapping("/edit")
	    public String editStudent(@RequestParam int id,Model m) {
	        m.addAttribute("data", service.getStudentById(id)); 
	        return "edit";
	    }
}

