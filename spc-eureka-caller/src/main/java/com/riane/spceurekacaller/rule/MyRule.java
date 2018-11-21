package com.riane.spceurekacaller.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRule implements IRule {

    private ILoadBalancer loadBalancer;

    @Override
    public Server choose(Object key) {
        System.err.println(key);
        List<Server> allServers = loadBalancer.getAllServers();
        List<Server> reachableServers = loadBalancer.getReachableServers();
        if (allServers.size() == reachableServers.size() && allServers.size() > 1) {
            return reachableServers.get(1);
        } else {
            return allServers.get(0);
        }
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.loadBalancer = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return loadBalancer;
    }
}
