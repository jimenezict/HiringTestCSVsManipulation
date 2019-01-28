# HiringTestCSVsManipulation

Welcome to the "Hiring Test" where we are going to check basic skills of Java on reading and saving data on CSV's

You could clone this code and create a specific branch for yourself.

What do we need you to do. You should be able to read an structured CSV composed of the fields

* Id: autoincremental numeric
* Cliente: name of the client (without comma, dont worry for that)
* Date: following the format YYYY-MM-DD
* Incomes: it is a natural possitive number
* Zone: it is one of the four schools of Gryffindor, Hufflepuff, Ravenclaw, Slytherin

On a first step it is requested to read and parse the source file on the InputObject
On a second step you will need to agregate the incomes by client and zone on a unique OutputObject where no duplicates combination of zone and clients are allowed
On a third step you will need to split the list of OutputObject on 4 differents list and finally write on a different CSV file each one
