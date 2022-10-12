package com.gl.crudApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.crudApplication.bean.Course;
import com.gl.crudApplication.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService service;
	
	@GetMapping("/index")
	public ModelAndView showIndexPage() {
		ModelAndView mv=new ModelAndView("index");
		List <Course> courseList=service.findAll();
		mv.addObject("courseList",courseList);
		return mv;
		
	}
	@GetMapping("/course-entry")
	public ModelAndView showCourseEntryPage() {
		Course course=new Course();
		ModelAndView mv=new ModelAndView("courseEntryPage");
		mv.addObject("courseRecord",course);
		return mv;
	}
	@PostMapping("/course")
	public ModelAndView saveNewCourse(@ModelAttribute("courseRecord") Course course) {
		long id=service.generateCourseId();
		course.setCourseId(id);
		service.save(course);
		return new ModelAndView("redirect:/index");
	}
	
	@GetMapping("/display-course/{id}")
	public ModelAndView showACourse(@PathVariable long id) {
		Course course=service.findById(id);
		ModelAndView mv=new ModelAndView("courseReportPage");
		mv.addObject("course",course);
		return mv;
	}
	@GetMapping("/delete-course/{id}")
	public ModelAndView deleteACourse(@PathVariable long id) {
		service.delete(id);
		return new ModelAndView("redirect:/index");
		
	}
	@GetMapping("/edit-course/{id}")
	public ModelAndView showCourseEditPage(@PathVariable long id) {
		Course course=service.findById(id);
		ModelAndView mv=new ModelAndView("courseEditPage");
		mv.addObject("courseRecord",course);
		return mv;
	}
	@PostMapping("/course-edit")
	public ModelAndView editCourse(@ModelAttribute("courseRecord") Course course) {
		service.save(course);
		return new ModelAndView("redirect:/index");
	}
}
	
	
	



