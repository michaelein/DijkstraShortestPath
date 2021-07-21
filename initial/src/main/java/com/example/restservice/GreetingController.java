package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    public ParseJSON  parseJSON ;
    @Autowired
    private WeightedGraph weightedGraph;

    //http://localhost:8080/api/getWeighted?start=d1263a41-5e00-4d6b-9611-0af0cdf371ce&end=f85456a2-4869-4678-b0eb-d855db8c2a1c
    @GetMapping("/api/getWeighted")
    @ResponseBody
    public String getWeighted(@RequestParam(name = "start") String start, @RequestParam String end) {

        double weight=  weightedGraph.getWeightBetweenNodes(start,end);
        String StringToSend="Start:" + start + " End: " + end+" Weight: ";
        if (weight==0) {
            return StringToSend+ " Unable to find one vertex";
        }
        return StringToSend + weight;
    }
    //http://localhost:8080/api/getShort?start=d1263a41-5e00-4d6b-9611-0af0cdf371ce&end=f85456a2-4869-4678-b0eb-d855db8c2a1c
    @GetMapping("/api/getShort")
    @ResponseBody
    public String getShort(@RequestParam(name = "start") String start, @RequestParam String end) {
        String Res=  weightedGraph.getShortBetweenNodes(start,end);
        return "Start:" + start + " End: " + end+" path: "+Res;// true or false to users
    }
    //http://localhost:8080/api/updateWeight?start=d1263a41-5e00-4d6b-9611-0af0cdf371ce&end=f85456a2-4869-4678-b0eb-d855db8c2a1c&weight=5
    @GetMapping("/api/updateWeight")//TODO Synchronization is not maintained by the library --important !!!
    @ResponseBody
    public String updateWeight(@RequestParam(name = "start") String start, @RequestParam String end,@RequestParam double weight) {
        boolean res=  weightedGraph.UpdateWeight(start,end ,weight);
        return "updateWeight Start:" + start + " End: " + end+" updated: "+res;// true or false to users
    }

}