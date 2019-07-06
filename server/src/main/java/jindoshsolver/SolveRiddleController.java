package main.java.jindoshsolver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    private static int personId(String person) {
        switch (person)
        {
            case "Lady Winslow": return WINSLOW;
            case "Doctor Marcolla": return MARCOLLA;
            case "Countess Contee": return CONTEE;
            case "Madam Natsiou": return NATSIOU;
            case "Baroness Finch": return FINCH;
            default: return -1;
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

    private static int colorId(String color)
    {
        switch (color)
        {
            case "blue": return BLUE;
            case "green": return GREEN;
            case "purple": return PURPLE;
            case "red": return RED;
            case "white": return WHITE;
            default: return -1;
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

    private static int drinkId(String drink)
    {
        switch (drink)
        {
            case "absinthe": return ABSINTHE;
            case "beer": return BEER;
            case "whiskey": return WHISKEY;
            case "wine": return WINE;
            case "rum": return RUM;
            default: return -1;
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

    private static int placeId(String place)
    {
        switch (place)
        {
            case "Baleton": return BALETON;
            case "Dabokva": return DABOKVA;
            case "Dunwall": return DUNWALL;
            case "Fraeport": return FRAEPORT;
            case "Karnaca": return KARNACA;
            default: return -1;
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

    private static int itemId(String item)
    {
        switch (item)
        {
            case "Bird Pendant": return BIRD;
            case "Diamond": return DIAMOND;
            case "Ring": return RING;
            case "Snuff Tin": return TIN;
            case "War Medal": return MEDAL;
            default: return -1;
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
        
        model.arithm(people[0], "=", personId(params.get("farLeftWoman"))).post();

        model.arithm(colors[1], "=", colorId(params.get("jacketColor"))).post();

        int leftColorId = colorId(params.get("pairLeftColor"));
        int rightColorId = colorId(params.get("pairRightColor"));
        model.or(
                model.and(
                        model.arithm(colors[0], "=", leftColorId),
                        model.arithm(colors[1], "=", rightColorId)
                ),
                model.and(
                        model.arithm(colors[1], "=", leftColorId),
                        model.arithm(colors[2], "=", rightColorId)
                ),
                model.and(
                        model.arithm(colors[2], "=", leftColorId),
                        model.arithm(colors[3], "=", rightColorId)
                ),
                model.and(
                        model.arithm(colors[3], "=", leftColorId),
                        model.arithm(colors[4], "=", rightColorId)
                )
        ).post();

        matchValueIndices(model, colors, colorId(params.get("hatColor")), people, personId(params.get("hatOwner")));

        matchValueIndices(model, drinks, drinkId(params.get("spilledDrink")), colors, colorId(params.get("spilledDrinkColor")));

        model.arithm(drinks[2], "=", drinkId(params.get("centerDrink"))).post();

        matchValueIndices(model, locations, placeId(params.get("storyTellerLocation")), people, personId(params.get("storyTeller")));

        matchValueIndices(model, colors, colorId(params.get("entirelyColor")), locations, placeId(params.get("entirelyColorLocation")));

        matchValueIndices(model, people, personId(params.get("toaster")), drinks, drinkId(params.get("toastDrink")));

        matchValueIndices(model, locations, placeId(params.get("tableJumperLocation")), drinks, drinkId(params.get("tableJumperDrink")));

        matchValueIndices(model, people, personId(params.get("prizedHeirloomOwner")), heirlooms, itemId(params.get("prizedHeirloom")));

        matchValueIndices(model, locations, placeId(params.get("scoffingWomanLocation")), heirlooms, itemId(params.get("scoffingWomanHeirloom")));

        int nearSpillInstigatorLocationId = placeId(params.get("nearSpillInstigatorLocation"));
        int valuableHeirloomId = itemId(params.get("valuableHeirloom"));
        model.or(
                model.and(
                        model.arithm(locations[0], "=", nearSpillInstigatorLocationId),
                        model.arithm(heirlooms[1], "=", valuableHeirloomId)
                ),
                model.and(
                        model.arithm(locations[1], "=", nearSpillInstigatorLocationId),
                        model.or(
                                model.arithm(heirlooms[0], "=", valuableHeirloomId),
                                model.arithm(heirlooms[2], "=", valuableHeirloomId)
                        )
                ),
                model.and(
                        model.arithm(locations[2], "=", nearSpillInstigatorLocationId),
                        model.or(
                                model.arithm(heirlooms[1], "=", valuableHeirloomId),
                                model.arithm(heirlooms[3], "=", valuableHeirloomId)
                        )
                ),
                model.and(
                        model.arithm(locations[3], "=", nearSpillInstigatorLocationId),
                        model.or(
                                model.arithm(heirlooms[2], "=", valuableHeirloomId),
                                model.arithm(heirlooms[4], "=", valuableHeirloomId)
                        )
                ),
                model.and(
                        model.arithm(locations[4], "=", nearSpillInstigatorLocationId),
                        model.arithm(heirlooms[3], "=", valuableHeirloomId)
                )
        ).post();

        int nearSpillDrinkId = drinkId(params.get("nearSpillDrink"));
        model.or(
                model.and(
                        model.arithm(locations[0], "=", nearSpillInstigatorLocationId),
                        model.arithm(drinks[1], "=", nearSpillDrinkId)
                ),
                model.and(
                        model.arithm(locations[1], "=", nearSpillInstigatorLocationId),
                        model.or(
                                model.arithm(drinks[0], "=", nearSpillDrinkId),
                                model.arithm(drinks[2], "=", nearSpillDrinkId)
                        )
                ),
                model.and(
                        model.arithm(locations[2], "=", nearSpillInstigatorLocationId),
                        model.or(
                                model.arithm(drinks[1], "=", nearSpillDrinkId),
                                model.arithm(drinks[3], "=", nearSpillDrinkId)
                        )
                ),
                model.and(
                        model.arithm(locations[3], "=", nearSpillInstigatorLocationId),
                        model.or(
                                model.arithm(drinks[2], "=", nearSpillDrinkId),
                                model.arithm(drinks[4], "=", nearSpillDrinkId)
                        )
                ),
                model.and(
                        model.arithm(locations[4], "=", nearSpillInstigatorLocationId),
                        model.arithm(drinks[3], "=", nearSpillDrinkId)
                )
        ).post();

        int braggedAboutHeirloomId = itemId(params.get("braggedAboutHeirloom"));
        int finerHeirloomLocationId = placeId(params.get("finerHeirloomLocation"));
        model.or(
                model.and(
                        model.arithm(heirlooms[0], "=", braggedAboutHeirloomId),
                        model.arithm(locations[1], "=", finerHeirloomLocationId)
                ),
                model.and(
                        model.arithm(heirlooms[1], "=", braggedAboutHeirloomId),
                        model.or(
                                model.arithm(locations[0], "=", finerHeirloomLocationId),
                                model.arithm(locations[2], "=", finerHeirloomLocationId)
                        )
                ),
                model.and(
                        model.arithm(heirlooms[2], "=", braggedAboutHeirloomId),
                        model.or(
                                model.arithm(locations[1], "=", finerHeirloomLocationId),
                                model.arithm(locations[3], "=", finerHeirloomLocationId)
                        )
                ),
                model.and(
                        model.arithm(heirlooms[3], "=", braggedAboutHeirloomId),
                        model.or(
                                model.arithm(locations[2], "=", finerHeirloomLocationId),
                                model.arithm(locations[4], "=", finerHeirloomLocationId)
                        )
                ),
                model.and(
                        model.arithm(heirlooms[4], "=", braggedAboutHeirloomId),
                        model.arithm(locations[3], "=", finerHeirloomLocationId)
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
