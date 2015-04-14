/*
 * Copyright (c) 2014 Manuel Rodriguez
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package controllers;

import java.util.ArrayList;

import models.Person;
import models.PersonList;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.uprm.ece.icom4035.classes.Gem;

public class PersonController extends Controller {

	public static Result getPerson(Long id) {////////////HACER CON DLL
		ArrayList<Gem> gemlist = new ArrayList<Gem>();
		Gem gemone = new Gem("Azurite", 8, 110.50, 7, "#CCC", 14);
		String descripGEMONE ="Some gems have hidden qualities beyond their luster, beyond their shine... Azurite is one of those gems.";
		gemone.setDescription(descripGEMONE);
		Gem gemtwo = new Gem("BloodStone", 9, 22.90, 6, "#EEE", 12);
		String descripGEmTWO ="Origin of the Bloodstone is unknown, hence its low value. It has a very high shine and 12 sides, however.";
		gemtwo.setDescription(descripGEmTWO);
		Gem gemthree = new Gem("Zircon", 70, 1100, 2, "#000", 6);
		String description3 = "Zircon is our most coveted and sought after gem. You will pay much to be the proud owner of this gorgeous and high shine gem.";
		gemthree.setDescription(description3);
		gemlist.add(gemone);
		gemlist.add(gemtwo);
		gemlist.add(gemthree);
		
		ObjectMapper mapperforJSONARRAY= new ObjectMapper();
		ArrayNode arrFORJSONARRAY = mapperforJSONARRAY.createArrayNode();
	
		ObjectNode objJS = Json.newObject();
		objJS.put("name",gemlist.get(0).getName());
		objJS.put("description", gemlist.get(0).getDescription());
		objJS.put("shine", gemlist.get(0).getShine());
		objJS.put("price", gemlist.get(0).getPrice());
		objJS.put("rarity",gemlist.get(0).getRarity());
		objJS.put("color", gemlist.get(0).getColor());
		objJS.put("faces", gemlist.get(0).getFaces());
		ObjectMapper mapper2 = new ObjectMapper();
		ArrayNode imagesjs1 = mapper2.createArrayNode();
		imagesjs1.add("gem-02.gif");
		imagesjs1.add("gem-05.gif");
		imagesjs1.add("gem-09.gif");
		objJS.put("images",imagesjs1);
		
		ObjectNode objJS2 = Json.newObject();
		objJS2.put("name",gemlist.get(1).getName());
		objJS2.put("description", gemlist.get(1).getDescription());
		objJS2.put("shine", gemlist.get(1).getShine());
		objJS2.put("price", gemlist.get(1).getPrice());
		objJS2.put("rarity",gemlist.get(1).getRarity());
		objJS2.put("color", gemlist.get(1).getColor());
		objJS2.put("faces", gemlist.get(1).getFaces());
		ObjectMapper mapper3 = new ObjectMapper();
		ArrayNode imagesjs2 = mapper3.createArrayNode();
		imagesjs2.add("gem-01.gif");
		imagesjs2.add("gem-03.gif");
		imagesjs2.add("gem-04.gif");
		objJS2.put("images",imagesjs2);
		
		
		ObjectNode objJS3 = Json.newObject();
		objJS3.put("name",gemlist.get(2).getName());
		objJS3.put("description", gemlist.get(2).getDescription());
		objJS3.put("shine", gemlist.get(2).getShine());
		objJS3.put("price", gemlist.get(2).getPrice());
		objJS3.put("rarity",gemlist.get(2).getRarity());
		objJS3.put("color", gemlist.get(2).getColor());
		objJS3.put("faces", gemlist.get(2).getFaces());
		ObjectMapper mapper4 = new ObjectMapper();
		ArrayNode imagesjs3 = mapper3.createArrayNode();
		imagesjs3.add("gem-06.gif");
		imagesjs3.add("gem-07.gif");
		imagesjs3.add("gem-08.gif");	
		objJS3.put("images",imagesjs3);
		
		arrFORJSONARRAY.add(objJS);
		arrFORJSONARRAY.add(objJS2);
		arrFORJSONARRAY.add(objJS3);
		return ok(arrFORJSONARRAY);
	}

	@BodyParser.Of(BodyParser.Json.class)
	public static Result storePerson() {
		ObjectMapper mapper = new ObjectMapper();
		try {

			JsonNode json = request().body().asJson();

			Person newPerson = mapper.readValue(json.toString(), Person.class);
			PersonList theList = PersonList.getInstance();
			newPerson = theList.addPerson(newPerson);
			ObjectNode result = Json.newObject();
			result.put("Person", Json.toJson(newPerson));
			return created(result);
		} catch (Exception e) {
			e.printStackTrace();
			return badRequest("Missing information");
		}

	}

	@BodyParser.Of(BodyParser.Json.class)
	public static Result updatePerson(Long id) {
		ObjectMapper mapper = new ObjectMapper();
		try {

			JsonNode json = request().body().asJson();
			Person updPerson = mapper.readValue(json.toString(), Person.class);
			PersonList theList = PersonList.getInstance();
			updPerson = theList.updatePerson(updPerson);
			if (updPerson == null) {
				return notFound("Person Not Found"); // 404
			} else {
				ObjectNode result = Json.newObject();
				result.put("Person", Json.toJson(updPerson));
				return ok(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return badRequest("Missing information");
		}
	}

	public static Result deletePerson(Long id) {
		PersonList theList = PersonList.getInstance();
		boolean erased = theList.deletePerson(id);
		if (erased) {
			// This is code 204 - OK with no content to return
			return noContent();
		} else {
			return notFound("Person Not Found");
		}

	}

}
