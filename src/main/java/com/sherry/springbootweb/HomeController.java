package com.sherry.springbootweb;

import com.sherry.springbootweb.com.sherry.springbootweb.dao.AlienRepo;
import com.sherry.springbootweb.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.HttpMethodConstraint;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

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
            mv.addObject("result","Entry that you want to delete does not exist");
        }
        return mv;
    }
    @RequestMapping("updateAlien")
    public ModelAndView updateAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname,@RequestParam("alang") String alang)
    {
        Alien alien= repo.findById(aid).orElse(new Alien());
        alien.setAname(aname);
        alien.setAlang(alang);
        repo.save(alien);
        ModelAndView mv= new ModelAndView("home");
        mv.addObject("result","Update Done!");
        return mv;
    }
    @RequestMapping(value = "/aliens")
    @ResponseBody
    public List<Alien> getAliensRest()
    {
        return repo.findAll();
    }

    @RequestMapping("/alien/{aid}")
    @ResponseBody
    public Optional<Alien> getAlienRest(@PathVariable("aid") int aid)
    {
        return repo.findById(102);
    }
}