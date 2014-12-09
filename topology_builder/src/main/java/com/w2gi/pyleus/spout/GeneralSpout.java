package com.w2gi.pyleus.spout;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import backtype.storm.Config;
import backtype.storm.task.ShellBolt;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;

import com.yelp.pyleus.spout.PythonSpout;

public class GeneralSpout extends com.yelp.pyleus.spout.PythonSpout {

    public GeneralSpout(final String... command) {
        super(command);
    }
}
