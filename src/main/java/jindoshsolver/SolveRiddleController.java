package main.java.jindoshsolver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SolveRiddleController
{
    @RequestMapping(value = "/solve", method = RequestMethod.GET)
    public SolveRiddle solveRiddle(@RequestParam Map<String,String> params)
    {
        return new SolveRiddle(1337);
    }
}
