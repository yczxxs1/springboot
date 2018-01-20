package com.netflix.common.metrics;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.stereotype.Component;

@Component
public class ServiceMetrics implements PublicMetrics {

	@Override
	public Collection<Metric<?>> metrics() {
		// TODO Auto-generated method stub
		List<Metric<?>> metrics =new LinkedList<>();
		metrics.add(new Metric<Integer>("uav.count",2));
		return metrics;
	}

}
