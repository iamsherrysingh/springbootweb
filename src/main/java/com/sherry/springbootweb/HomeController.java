package com.sherry.springbootweb;

import com.sherry.springbootweb.com.sherry.springbootweb.dao.AlienRepo;
import com.sherry.springbootweb.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home()
    {
        return "home";
    }

    @RequestMapping("addAlien")
    public ModelAndView addAlien(Alien alien)
    {
        repo.save(alien);
        ModelAndView mv= new ModelAndView("home");
        mv.addObject("result","Added Alien!");
        return mv;
    }
    @RequestMapping("getAlien")
    public ModelAndView getAlien(@RequestParam int aid)
    {
        ModelAndView mv = new ModelAndView();
        Alien alien=repo.findById(aid).orElse(new Alien());
        mv.addObject("alien",alien);
        mv.setViewName("showAlien");
        return mv;
    }
    @RequestMapping("deleteAlien")
    public ModelAndView deleteAlien(@RequestParam int aid)
    {
        ModelAndView mv= new ModelAndView("home");
        try
        {
            repo.deleteById(aid);
            mv.addObject("result","Deleted!");
        }
        catch(EmptyResultDataAccessException e)
        {
            mv.addObject("result","Entry that you added does not exist");
        }

        return mv;
    }
    @RequestMapping("updateAlien")
    public ModelAndView updateAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname)
    {
        Alien alien= repo.findById(aid).orElse(new Alien());
        alien.setAname(aname);
        repo.save(alien);
        ModelAndView mv= new ModelAndView("home");
        mv.addObject("result","Update Done!");
        return mv;
    }
}