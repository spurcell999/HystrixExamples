package com.purcell.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.purcell.hystrix.domain.Racecourse;
import com.purcell.hystrix.exception.RemoteServiceException;
import com.purcell.hystrix.service.BettingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e026459 on 5/8/2018.
 */
public class CommandGetTodaysRaces extends HystrixCommand<List<Racecourse>> {

    private final BettingService service;
    private final boolean failSilently;

    public CommandGetTodaysRaces(BettingService service) {
        this(service, true);
    }

    public CommandGetTodaysRaces(BettingService service, boolean failSilently) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("BettingServiceGroup"))
        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("BettingServicePool")));

        this.service = service;
        this.failSilently = failSilently;
    }

    @Override
    protected List<Racecourse> run() {
        return service.getTodaysRaces();
    }


    @Override
    protected List<Racecourse> getFallback() {
        // can log here, throw exception or return default
        if (failSilently) {
            return new ArrayList<Racecourse>();
        }

        throw new RemoteServiceException("Unexpected error retrieving todays races");

    }

}
