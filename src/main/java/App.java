import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("placeses", request.session().attribute("placeses"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/placeses", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();

    ArrayList<Places> placeses = request.session().attribute("placeses");
    if (placeses == null) {
      placeses = new ArrayList<Places>();
      request.session().attribute("placeses", placeses);
    }
    String country = request.queryParams("country");
    String city = request.queryParams("city");
    Integer year = Integer.parseInt(request.queryParams("year"));
    String purpose = request.queryParams("purpose");

    Places newPlaces = new Places(country, city, year, purpose);
    placeses.add(newPlaces);

    model.put("template", "templates/placeAdded.vtl");
    return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

    }

  }
