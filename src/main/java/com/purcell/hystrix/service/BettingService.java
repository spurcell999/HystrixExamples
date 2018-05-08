package com.purcell.hystrix.service;

import com.purcell.hystrix.domain.Horse;
import com.purcell.hystrix.domain.Racecourse;

import java.util.List;

/**
 * Created by e026459 on 5/8/2018.
 */
public interface BettingService {

    /**
     * Get a list the names of all Race courses with races on today.
     * @return List of race course names
     */
    List<Racecourse> getTodaysRaces();

    /**
     * Get a list of all Horses running in a particular race.
     * @param race Name of race course
     * @return List of the names of all horses running in the specified race
     */
    List<Horse> getHorsesInRace(String raceCourseId);

    /**
     * Get current odds for a particular horse in a specific race today.
     * @param race Name of race course
     * @param horse Name of horse
     * @return Current odds as a string (e.g. "10/1")
     */
    String getOddsForHorse(String raceCourseId, String horseId);
}
