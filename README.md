# taxCalculator

This is a java application focus to calculate the congestion tax of the vehicle which are parked from one timeslot to another.
The entry point for this is a HTTP endpoint "http://localhost:8080/api/v1/toll/calculate"
You can also check the test cases covered in this to handle the corner case scenarios which are given in the task.
Conditions satisfied are:

Congestion tax is charged during fixed hours for vehicles driving into and out of Gothenburg.

The maximum amount per day and vehicle is 60 SEK.

The tax is not charged on weekends (Saturdays and Sundays), public holidays, days before a public holiday and during the month of July.

A single charge rule applies in Gothenburg

Code is extensible to the other cities and different rates in future.
