package com.w2gi.pyleus.spout;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.storm.Config;
import org.apache.storm.task.ShellBolt;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;

import com.yelp.pyleus.spout.PythonSpout;

public class GeneralSpout extends com.yelp.pyleus.spout.PythonSpout {

    public GeneralSpout(final String... command) {
        super(command);
    }
}
