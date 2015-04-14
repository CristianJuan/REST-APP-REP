package controllers;

import java.io.IOException;
import java.util.ArrayList;




import play.api.libs.json.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.uprm.ece.icom4035.classes.*;
import edu.uprm.ece.icom4035.list.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.uprm.ece.icom4035.classes.Gem;

public class Application extends Controller {

    public static Result index() throws IOException {
    	return ok("IM HERE INDEX OF APPLICATION");
    }
}
