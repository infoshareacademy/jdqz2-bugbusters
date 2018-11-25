package com.infoshare.bug_busters.dataFromJson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverClassJson {

    ObjectMapper mapper = new ObjectMapper();

try

    {

        // Convert JSON string from file to Object
        User user = mapper.readValue(new File("G:\\user.json"), User.class);
        System.out.println(user);

        // Convert JSON string to Object
        String jsonInString = "{\"age\":33,\"messages\":[\"msg 1\",\"msg 2\"],\"name\":\"mkyong\"}";
        User user1 = mapper.readValue(jsonInString, User.class);
        System.out.println(user1);

    } catch(
    JsonGenerationException e)

    {
        e.printStackTrace();
    } catch(
    JsonMappingException e)

    {
        e.printStackTrace();
    } catch(
    IOException e)

    {
        e.printStackTrace();
    }

}
}
