# HackerRank_SortingWithComparator

### Overview

This repository contains my Java SE 8 solution to the HackerRank problem [Sorting: Comparator](https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem).

Of most interest is one of the JUnit tests I've setup where I've written the test 5 different 
ways illustrating how the comparator can be written more efficiently and elegantly in Java 8:

      1. Test with Comparator defined in a separate class - commented out.
      2. Test with Comparator defined in a anonymous in-line class - commented out.
      3. Test with Comparator defined in-line within the sort statement - commented out.
      4. Test with Comparator defined in-line within the sort statement using a Lambda expression - commented out.
      5. Test with Comparator methods comparing() and thenComparing(), and method reference :: - final version.  

### Problem 
 
Comparators are used to compare two objects. In this challenge, you'll create a comparator and 
use it to sort an array. The Player class is provided. It has two fields:

      1. name:  a string.
      2. score: an integer.
     
Given an array of n Player objects, write a comparator that sorts them in order of decreasing 
score. If 2 or more players have the same score, sort those players alphabetically ascending by 
name. To do this, you must create a Checker class that implements the Comparator interface, then 
write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) 
method.
   
In short, when sorting in ascending order, a comparator function returns

      -1 if a < b, 
       0 if a = b, and
       1 if a> b.
   
For example, given n = 3 Player objects with Player.name, Player.score values of 

     data = [[Smith,20],[Jones,15],[Jones,20]]
     
We want to sort the list as

     dataSorted = [[Jones,20],[Smith,20],[Jones,15]]
   
### Function Description

Declare a Checker class that implements the comparator method as described. It should sort 
first descending by score, then ascending by name. The code stub reads the input, creates a 
list of Player objects, uses your method to sort the data, and prints it out properly.
   
### Input Format
 
   - The first line contains an integer, n, the number of players.
   - Each of the next n lines contains a player's respective name and score, a string and an integer.
 
### Constraints
 
   - 0 <= score <= 1000
   - two or more players can have the same name
   - Player names consist of lowercase English alphabetic letters.
 
### Output Format
 
   - You are not responsible for printing any output to stdout. Locked stub code in Solution will 
   - create a Checker object, use it to sort the Player array, and print each sorted element.

### Testcases
   
   - Testcase 0 
      - Input
      
		    [amy,100]
		    [david,100]
		    [heraldo,50]
		    [aakansha,75]
		    [aleksa,150]   
        
      - Expected Output
      
		    [aleksa,150]   
		    [amy,100]
		    [david,100]
		    [aakansha,75]
		    [heraldo,50]
