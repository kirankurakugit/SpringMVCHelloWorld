package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
@Controller
@RequestMapping("/username")
public class MovieController {

	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {



  String dateStr_1 ="02-May-1991";
  String username="Anusha";
  String birthdayy;
        LocalDate today = LocalDate.now();
   DateTimeFormatter formatter_1=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
   LocalDate birthday= LocalDate.parse(dateStr_1,formatter_1);
       // LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

        LocalDate nextBDay = birthday.withYear(today.getYear());

        //If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        //System.out.println("There are " + p.getMonths() + " months, and " +
                         //  p.getDays() + " days until your next birthday. (" +
                          // p2 + " total)");

        birthdayy="There ae "+p.getMonths() +"months,and"+ p.getDays() +"days until your next birthday";
        System.out.println(birthdayy);




            model.addAttribute("message",birthdayy);



		model.addAttribute("username", name);
		return "list";

	}
	
}