package com.capas.tarea5.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capas.tarea5.dao.EstudianteDAO;
import com.capas.tarea5.domain.Estudiante;
import com.capas.tarea5.service.EstudianteService;

@Controller
public class MainController {
	@Autowired
	private EstudianteService estudianteService;

	@RequestMapping("listado")
	public ModelAndView Listado() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}

	@RequestMapping("inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("ingresarEstudiante")
	public ModelAndView findOne(@Valid() @ModelAttribute() Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("index");
			return mav;
		}
		try {
			estudianteService.save(estudiante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("index");
		return mav;
	}
	
    @RequestMapping(value = "/borrarEstudiante")
    public ModelAndView borrarEstudiante(@RequestParam(value="codigo") int id) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudianteService.delete(id);
            estudiantes = estudianteService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("listado");
        return mav;
    }
    
    @RequestMapping(value = "/filtrarEstudiante")
    public ModelAndView filtrarEstudiante(@RequestParam(value="cadena") String cadena) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudiantes = estudianteService.filtrarPor(cadena);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
        return mav;
    }
    
	@RequestMapping("modificarEstudiante")
	public ModelAndView modificarEstudiante(@Valid() @ModelAttribute() Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("modificarEstudiante");
			return mav;
		}
		try {
			estudianteService.save(estudiante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("buscarYModificarEstudiante")
    public ModelAndView buscarEstudiante(@RequestParam(value="codigo") int codigo) {
        ModelAndView mav = new ModelAndView();
        Estudiante estudiante = null;
        try {
            estudiante = estudianteService.findOne(codigo);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("estudiante", estudiante);
		mav.setViewName("modificarEstudiante");
        return mav;
    }
	
}
