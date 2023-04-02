package almosafer.almosafer;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class POST_DATA {
	String getUri(){
        return "/api/enigma/search/async";
    }
	 static String getplaceId(){
        return "ChIJdd4hrwug2EcRmSrV3Vo6llI";
    }
	 static String getcheckoutDate(){
        return "2023-04-16";
    }
	 static String getcheckinDate(){
        return "2023-04-15";
    }
	 String getContentType(){
        return "application/json";
    }
	 String gettokene(){
        return "skdjfh73273$7268u2j89s";
    }
	 static int getadultsCount(){
        return 2;
    }
	public static ArrayNode getroominfo(){
		
		JsonNodeFactory factory = JsonNodeFactory.instance;
		
		ArrayNode roomsInfo = factory.arrayNode();
		ObjectNode room = factory.objectNode();
		room.put("adultsCount", getadultsCount());
		ArrayNode kidsAges = factory.arrayNode();
		room.set("kidsAges", kidsAges);
		roomsInfo.add(room);
        return roomsInfo;
    }
public ObjectNode getbodyinfo(){
		
	
	JsonNodeFactory factory = JsonNodeFactory.instance;

	ObjectNode json = factory.objectNode();
	json.put("checkIn", getcheckinDate());
	json.put("checkOut", getcheckoutDate());
	json.putNull("searchInfo");
	json.putNull("crossSellDetail");
	json.put("placeId", getplaceId());

	
	json.set("roomsInfo", getroominfo());
	return json;
    }

}
