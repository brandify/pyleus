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
        String file = type;
        boolean localcmd = type.startsWith("./");
        String[] command = new String[(localcmd) ? 5 : 4];
        int idx = 0;
        //command.add(type);
        //command.add(module);
        if (localcmd) {
            file = type.replaceFirst("\\./", "");
//            command[idx] = "bash -c ";
//            idx += 1;
            command[idx] = String.format("bash -c \"chmod 755 %s\";", file);
            idx += 1;
        }
        command[idx] = file;
        idx += 1;
        command[idx] = module;
        idx += 1;
        
        if (argumentsMap != null) {
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(argumentsMap);
            //json = json.replace("\"", "\\\"");
            command[idx] = "--options";
            idx += 1;
            command[idx] = json; //String.format("\"%s\"", json);
            idx += 1;
        } else {
            command[idx] = "";
            idx += 1;
            command[idx] = "";
            idx += 1;
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
