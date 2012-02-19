package com.example.helloandroid.prefs;

import java.util.ArrayList;
import java.util.List;

import com.example.helloandroid.feed.model.Direction;
import com.example.helloandroid.feed.model.Stop;

public class NextBusDirection extends NextBusValue {
	private List<NextBusStop> stops; 

	public NextBusDirection init(Direction model) {
		stops = new ArrayList<NextBusStop>();
		super.init(model.getName(), model.getTitle(), model.getTag());
		for (Stop stop : model.getStops()) {
			NextBusStop nbs = new NextBusStop();
			nbs.init(stop);
			stops.add(nbs);
		}
		return this;
	}
	
	public List<NextBusStop> getStops() {
		return stops;
	}
}
