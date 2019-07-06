package main.java.jindoshsolver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
      hatOwner: "",
      hatColor: "",
      farLeftWoman: "",
      jacketColor: "",
      pairLeftColor: "",
      pairRightColor: "",
      spilledDrinkColor: "",
      spilledDrink: "",
      entirelyColorLocation: "",
      entirelyColor: "",
      braggedAboutHeirloom: "",
      finerHeirloomLocation: "",
      prizedHeirloomOwner: "",
      prizedHeirloom: "",
      scoffingWomanLocation: "",
      scoffingWomanHeirloom: "",
      valuableHeirloom: "",
      nearSpillInstigatorLocation: "",
      nearSpillDrink: "",
      toaster: "",
      toastDrink: "",
      tableJumperLocation: "",
      tableJumperDrink: "",
      centerDrink: "",
      storyTeller: "",
      storyTellerLocation: "",
      firstHeirloom: "",
      secondHeirloom: "",
      thirdHeirloom: "",
      fourthHeirloom: ""
 */

@RestController
public class SolveRiddleController
{
    private static final int WINSLOW = 0;
    private static final int MARCOLLA = 1;
    private static final int CONTEE = 2;
    private static final int NATSIOU = 3;
    private static final int FINCH = 4;

    private static final int BIRD = 0;
    private static final int DIAMOND = 1;
    private static final int RING = 2;
    private static final int MEDAL = 3;
    private static final int TIN = 4;

    private static final int WHITE = 0;
    private static final int RED = 1;
    private static final int PURPLE = 2;
    private static final int BLUE = 3;
    private static final int GREEN = 4;

    private static final int WINE = 0;
    private static final int WHISKEY = 1;
    private static final int RUM = 2;
    private static final int BEER = 3;
    private static final int ABSINTHE = 4;

    private static final int DABOKVA = 0;
    private static final int FRAEPORT = 1;
    private static final int BALETON = 2;
    private static final int DUNWALL = 3;
    private static final int KARNACA = 4;

    private static String person(int id)
    {
        switch (id)
        {
            case WINSLOW: return "Winslow";
            case MARCOLLA: return "Marcolla";
            case CONTEE: return "Contee";
            case NATSIOU: return "Natsiou";
            case FINCH: return "Finch";
            default: return "Unknown";
        }
    }

    private static String color(int id)
    {
        switch (id)
        {
            case WHITE: return "White";
            case RED: return "Red";
            case PURPLE: return "Purple";
            case BLUE: return "Blue";
            case GREEN: return "Green";
            default: return "Unknown";
        }
    }

    private static String drink(int id)
    {
        switch (id)
        {
            case WINE: return "Wine";
            case WHISKEY: return "Whiskey";
            case RUM: return "Rum";
            case BEER: return "Beer";
            case ABSINTHE: return "Absinthe";
            default: return "Unknown";
        }
    }

    private static String place(int id)
    {
        switch (id)
        {
            case DABOKVA: return "Dabokva";
            case FRAEPORT: return "Fraeport";
            case BALETON: return "Baleton";
            case DUNWALL: return "Dunwall";
            case KARNACA: return "Karnaca";
            default: return "Unknown";
        }
    }

    private static String item(int id)
    {
        switch (id)
        {
            case BIRD: return "Bird";
            case DIAMOND: return "Diamond";
            case RING: return "Ring";
            case MEDAL: return "Medal";
            case TIN: return "Tin";
            default: return "Unknown";
        }
    }

    private static void matchValueIndices(Model model, IntVar[] varsA, int valueA, IntVar[] varsB, int valueB)
    {
        model.or(
                model.and(
                        model.arithm(varsA[0], "=", valueA),
                        model.arithm(varsB[0], "=", valueB)
                ),
                model.and(
                        model.arithm(varsA[1], "=", valueA),
                        model.arithm(varsB[1], "=", valueB)
                ),
                model.and(
                        model.arithm(varsA[2], "=", valueA),
                        model.arithm(varsB[2], "=", valueB)
                ),
                model.and(
                        model.arithm(varsA[3], "=", valueA),
                        model.arithm(varsB[3], "=", valueB)
                ),
                model.and(
                        model.arithm(varsA[4], "=", valueA),
                        model.arithm(varsB[4], "=", valueB)
                )
        ).post();
    }

    @RequestMapping(value = "/solve", method = RequestMethod.GET)
    public SolveRiddle solveRiddle(@RequestParam Map<String,String> params)
    {
        Model model = new Model("Jindosh Riddle");
        IntVar[] people = model.intVarArray("People", 5, 0, 4);
        IntVar[] colors = model.intVarArray("Colors", 5, 0, 4);
        IntVar[] drinks = model.intVarArray("Drinks", 5, 0, 4);
        IntVar[] locations = model.intVarArray("Locations", 5, 0, 4);
        IntVar[] heirlooms = model.intVarArray("Heirlooms", 5, 0, 4);

        // All unique values per seat
        model.allDifferent(people).post();
        model.allDifferent(colors).post();
        model.allDifferent(drinks).post();
        model.allDifferent(locations).post();
        model.allDifferent(heirlooms).post();

        // Finch is on the far left
        model.arithm(people[0], "=", FINCH).post();

        // The red jacket is next to Finch (2nd seat along)
        model.arithm(colors[1], "=", RED).post();

        // Lady in blue is left of someone in purple
        model.or(
                model.and(
                        model.arithm(colors[0], "=", BLUE),
                        model.arithm(colors[1], "=", PURPLE)
                ),
                model.and(
                        model.arithm(colors[1], "=", BLUE),
                        model.arithm(colors[2], "=", PURPLE)
                ),
                model.and(
                        model.arithm(colors[2], "=", BLUE),
                        model.arithm(colors[3], "=", PURPLE)
                ),
                model.and(
                        model.arithm(colors[3], "=", BLUE),
                        model.arithm(colors[4], "=", PURPLE)
                )
        ).post();

        // Winslow is wearing white
        matchValueIndices(model, colors, WHITE, people, WINSLOW);

        // Woman in blue has wine
        matchValueIndices(model, drinks, WINE, colors, BLUE);

        // Absinthe is in the center
        model.arithm(drinks[2], "=", ABSINTHE).post();

        // Contee is from Karnaca
        matchValueIndices(model, locations, KARNACA, people, CONTEE);

        // Woman in green is from Dabokva
        matchValueIndices(model, colors, GREEN, locations, DABOKVA);

        // Natsiou has the rum
        matchValueIndices(model, people, NATSIOU, drinks, RUM);

        // Woman from Dunwall has beer
        matchValueIndices(model, locations, DUNWALL, drinks, BEER);

        // Marcolla has the Snuff Tin
        matchValueIndices(model, people, MARCOLLA, heirlooms, TIN);

        // Woman from Fraeport has a ring
        matchValueIndices(model, locations, FRAEPORT, heirlooms, RING);

        // Woman from Baleton sits next to someone with the Medal
        model.or(
                model.and(
                        model.arithm(locations[0], "=", BALETON),
                        model.arithm(heirlooms[1], "=", MEDAL)
                ),
                model.and(
                        model.arithm(locations[1], "=", BALETON),
                        model.or(
                                model.arithm(heirlooms[0], "=", MEDAL),
                                model.arithm(heirlooms[2], "=", MEDAL)
                        )
                ),
                model.and(
                        model.arithm(locations[2], "=", BALETON),
                        model.or(
                                model.arithm(heirlooms[1], "=", MEDAL),
                                model.arithm(heirlooms[3], "=", MEDAL)
                        )
                ),
                model.and(
                        model.arithm(locations[3], "=", BALETON),
                        model.or(
                                model.arithm(heirlooms[2], "=", MEDAL),
                                model.arithm(heirlooms[4], "=", MEDAL)
                        )
                ),
                model.and(
                        model.arithm(locations[4], "=", BALETON),
                        model.arithm(heirlooms[3], "=", MEDAL)
                )
        ).post();

        // Woman from Baleton sits next to someone with whiskey
        model.or(
                model.and(
                        model.arithm(locations[0], "=", BALETON),
                        model.arithm(drinks[1], "=", WHISKEY)
                ),
                model.and(
                        model.arithm(locations[1], "=", BALETON),
                        model.or(
                                model.arithm(drinks[0], "=", WHISKEY),
                                model.arithm(drinks[2], "=", WHISKEY)
                        )
                ),
                model.and(
                        model.arithm(locations[2], "=", BALETON),
                        model.or(
                                model.arithm(drinks[1], "=", WHISKEY),
                                model.arithm(drinks[3], "=", WHISKEY)
                        )
                ),
                model.and(
                        model.arithm(locations[3], "=", BALETON),
                        model.or(
                                model.arithm(drinks[2], "=", WHISKEY),
                                model.arithm(drinks[4], "=", WHISKEY)
                        )
                ),
                model.and(
                        model.arithm(locations[4], "=", BALETON),
                        model.arithm(drinks[3], "=", WHISKEY)
                )
        ).post();

        // Woman with Bird sits next to someone from Dabokva
        model.or(
                model.and(
                        model.arithm(heirlooms[0], "=", BIRD),
                        model.arithm(locations[1], "=", DABOKVA)
                ),
                model.and(
                        model.arithm(heirlooms[1], "=", BIRD),
                        model.or(
                                model.arithm(locations[0], "=", DABOKVA),
                                model.arithm(locations[2], "=", DABOKVA)
                        )
                ),
                model.and(
                        model.arithm(heirlooms[2], "=", BIRD),
                        model.or(
                                model.arithm(locations[1], "=", DABOKVA),
                                model.arithm(locations[3], "=", DABOKVA)
                        )
                ),
                model.and(
                        model.arithm(heirlooms[3], "=", BIRD),
                        model.or(
                                model.arithm(locations[2], "=", DABOKVA),
                                model.arithm(locations[4], "=", DABOKVA)
                        )
                ),
                model.and(
                        model.arithm(heirlooms[4], "=", BIRD),
                        model.arithm(locations[3], "=", DABOKVA)
                )
        ).post();

        Solver solver = model.getSolver();
        int count = 0;
        while (solver.solve())
        {
            System.out.println("SOLUTION #" + count + ":");

            System.out.print("People: " + person(people[0].getValue()));
            for (int seat = 1; seat < people.length; seat++)
            {
                System.out.print(", " + person(people[seat].getValue()));
            }
            System.out.println();

            System.out.print("Colors: " + color(colors[0].getValue()));
            for (int seat = 1; seat < colors.length; seat++)
            {
                System.out.print(", " + color(colors[seat].getValue()));
            }
            System.out.println();

            System.out.print("Drinks: " + drink(drinks[0].getValue()));
            for (int seat = 1; seat < drinks.length; seat++)
            {
                System.out.print(", " + drink(drinks[seat].getValue()));
            }
            System.out.println();

            System.out.print("Locations: " + place(locations[0].getValue()));
            for (int seat = 1; seat < locations.length; seat++)
            {
                System.out.print(", " + place(locations[seat].getValue()));
            }
            System.out.println();

            System.out.print("Heirlooms: " + item(heirlooms[0].getValue()));
            for (int seat = 1; seat < heirlooms.length; seat++)
            {
                System.out.print(", " + item(heirlooms[seat].getValue()));
            }
            System.out.println();

            System.out.println();
            count++;
        }

        return new SolveRiddle(1337);
    }
}
