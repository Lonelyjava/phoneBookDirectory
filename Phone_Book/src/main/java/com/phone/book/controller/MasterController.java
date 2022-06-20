package com.phone.book.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phone.book.model.Master;
import com.phone.book.reposistory.MasterRepos;
import com.phone.book.service.MasterAction;

@Controller
public class MasterController {
	
	 private static final Logger logger = LoggerFactory.getLogger(MasterController.class);
	 
	 
	@Autowired
	MasterRepos masterRepos;
	@RequestMapping("/master")
	public ModelAndView masterOpen(String  data,Model model)
	{
		Map<String,String> map = new HashMap<String, String>();
		map.put("value", data);
		System.out.println("value:"+data);
		model.addAttribute("value",data);
		return new ModelAndView("master",map);
//		return "master";
	}
	@RequestMapping("/savedata")
	public String saveMaster(Master master,Model model)
	{
		masterRepos.save(master);
		System.out.println("master saved successfully...");
		String msg = "Date Saved Successfully...";
		model.addAttribute("message", msg);
		logger.debug("kundan");
		return "master";
	}
	
	@RequestMapping("/viewMaster")
	public @ResponseBody List<Master> view(Master master)
	{
		List<Master> lis= new ArrayList<Master>();
//		masterRepos.findAll();
		ModelMap map = new ModelMap();
		map.put("name",master.getName());
		map.put("address",master.getAddress()); 
		map.put("mobile",master.getMobile());
		  
		  
		  ModelAndView andView = new ModelAndView("masterDetails");
		  andView.addObject("mas", lis);
		 
		return masterRepos.findAll();
	}
	@RequestMapping("/state")
	public String state(HttpServletRequest request,Model model,String action)
	{
		model.addAttribute("Viewstate",action);
		logger.debug("----");
		
		return "master";
	}
	@RequestMapping("/hello")
	public String hello()
	{
		return "hello";
	}
	
}
