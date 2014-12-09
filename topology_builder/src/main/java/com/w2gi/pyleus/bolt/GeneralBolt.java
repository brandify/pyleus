package com.w2gi.pyleus.bolt;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import backtype.storm.Config;
import backtype.storm.task.ShellBolt;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;

import com.yelp.pyleus.bolt.PythonBolt;

public class GeneralBolt extends com.yelp.pyleus.bolt.PythonBolt {

    public GeneralBolt(final String... command) {
        super(command);
    }
}

//public class GeneralBolt extends ShellBolt implements IRichBolt {
//
//    protected Map<String, Object> outputFields;
//    protected Float tickFreqSecs = null;
//
//    public GeneralBolt(final String... command) {
//        super(command);
//    }
//
//    public void setOutputFields(final Map<String, Object> outputFields) {
//        this.outputFields = outputFields;
//    }
//
//    public void setTickFreqSecs(Float tickFreqSecs) {
//        this.tickFreqSecs = tickFreqSecs;
//    }
//
//    @Override
//    public void declareOutputFields(OutputFieldsDeclarer declarer) {
//        // Can this condition ever happen?
//        if (this.outputFields.size() == 1 && this.outputFields.get("default") == null) {
//            declarer.declare(new Fields());
//        } else {
//            for (Entry<String, Object> outEntry : this.outputFields.entrySet()) {
//                String stream = outEntry.getKey();
//                @SuppressWarnings("unchecked")
//                List<String> fields = (List<String>) outEntry.getValue();
//                declarer.declareStream(stream, new Fields(fields.toArray(new String[fields.size()])));
//            }
//        }
//    }
//
//    @Override
//    public Map<String, Object> getComponentConfiguration() {
//        if (this.tickFreqSecs == null) {
//            return null;
//        }
//
//        Config conf = new Config();
//        conf.put(Config.TOPOLOGY_TICK_TUPLE_FREQ_SECS, this.tickFreqSecs);
//        return conf;
//    }
//}
