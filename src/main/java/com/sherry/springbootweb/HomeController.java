package com.sherry.springbootweb;

import com.sherry.springbootweb.com.sherry.springbootweb.dao.AlienRepo;
import com.sherry.springbootweb.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home()
    {
        return "home";
    }

    @PostMapping(path="alien", consumes = {"application/json"})
    public Alien addAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return alien;
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
    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid)
    {
        /*ModelAndView mv= new ModelAndView("home");
        try
        {
            repo.deleteById(aid);
            mv.addObject("result","Deleted!");
        }
        catch(EmptyResultDataAccessException e)
        {
            mv.addObject("result","Entry that you want to delete does not exist");
        }
        return mv;*/
        Alien a=repo.getOne(aid);
        repo.delete(a);
        return "Deleted";
    }
    @PutMapping(path="/alien",consumes = {"application/json"})
    public Alien updateAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return alien;
    }

    @GetMapping("/alien/{aid}")
    public Optional<Alien> getAlienRest(@PathVariable("aid") int aid)
    {
        return repo.findById(aid);
    }

    @GetMapping("/aliens")
    public List<Alien> getAlienRest()
    {
        return repo.findAll();
    }
}