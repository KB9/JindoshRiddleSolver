package main.java.jindoshsolver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.HashMap;

@SpringBootApplication
public class Solver
{
    public static void main(String[] args)
    {
        HashMap<String, Object> props = new HashMap<>();
        props.put("server.port", 3001);

        new SpringApplicationBuilder()
                .sources(Solver.class)
                .properties(props)
                .run(args);
    }
}
