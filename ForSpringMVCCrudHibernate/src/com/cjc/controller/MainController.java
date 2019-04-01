package com.cjc.controller;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.model.Student;
import com.cjc.serviceinterface.ServiceInterface;

@Controller
public class MainController {

	@Autowired
	ServiceInterface si;
	
	@RequestMapping("/")
	public String preLogin()
	{
		return "index";
	}
	
	@RequestMapping("/regi")
	public String preRegister()
	{
		return "register";
	}
	
	@RequestMapping(value="/register")
	public String registerStudent(@ModelAttribute Student s)
	{
		
		if(s.getRollno()==0)
		{
			int id=si.registerStudent(s);	
		}
		else
		{
			int id=si.updateStudent(s);
		}
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, ModelMap map)
	{
		if(username.equals("champ") && password.equals("champ"))
		{
			List<Student> list=si.getAllStudent();
			map.addAttribute("alldata", list);
			return "home";
		}
		else
		{
			List<Student> list=si.getOneStudent(username, password);
			Iterator<Student> itr=list.iterator();
			if(itr.hasNext())
			{
				map.addAttribute("alldata", list);
				return "home";
			}
			else
			{
				map.addAttribute("msg", "Please enter valid cridentials");
				return "index";
			}			
		}		
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam int id, ModelMap map)
	{
		Student s=si.getElementById(id);
		System.out.println(s);
		map.addAttribute("editdata", s);
		return "edit";
	}	
	
	@RequestMapping("/delete")
	public String deleterecord(int id)
	{
		si.deleteStudent(id);
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout()
	{
		return "index";
	}
}
