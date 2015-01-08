package com.w2gi.pyleus;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.w2gi.pyleus.bolt.GeneralBolt;
import com.w2gi.pyleus.spout.GeneralSpout;

public class GeneralComponentsFactory {
    private String[] buildCommand(final String type, final String module, final Map<String, Object> argumentsMap,
            final String loggingConfig, final String serializerConfig) {
        //List<String> command = new ArrayList<String>();
        //String[] command = { type, module };
        String[] command = new String[3];
        //command.add(type);
        //command.add(module);
        command[0] = type;
        command[1] = module;
        
        if (argumentsMap != null) {
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(argumentsMap);
            json = json.replace("\"", "\\\"");
            command[2] = String.format(" --options \"%s\"", json);
        } else {
            command[2] = "";
        }
        
        //return command.toArray(new String[1]);
        return command;
    }
    
    public GeneralBolt createGeneralBolt(final String type, final String module, final Map<String, Object> argumentsMap,
            final String loggingConfig, final String serializerConfig) {
        return new GeneralBolt(buildCommand(type, module, argumentsMap, loggingConfig, serializerConfig));
    }
    
    public GeneralSpout createGeneralSpout(final String type, final String module, final Map<String, Object> argumentsMap,
            final String loggingConfig, final String serializerConfig) {
        return new GeneralSpout(buildCommand(type, module, argumentsMap, loggingConfig, serializerConfig));
    }
}
