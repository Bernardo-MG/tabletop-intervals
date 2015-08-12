# Interval Structures

In tabletop games intervals are, commonly, closed, continuous and composed of integers. In part this is due to the fact that these games depend on dice to generate random values in a range, a fact which will dictate much of the way intervals are used.

This may not be so aparent in the most basic type of interval, but the other structure offered on this project, the intervals table, is used to map ranges of possible results from rolling dice to specific values.

## Interval

![Interval interface][interval_interface]

A basic [interval][interval_javadoc] is just composed of two limits. By themselves they have little use, but allow creating more complex data structures.

## Intervals Table

![Intervals Table interface][intervals_table_interface]

An [intervals table][intervals_table_javadoc] allows mapping values to the different results of rolling a dice.

For example, the following is Bloodbowl's table for weather:

|Interval|Result|
|---|---|
|2|Sweltering Heat|
|3|Very Sunny|
|4-10|Nice|
|11|Pouring rain|
|12|Blizzard|

The way this table is used is by rolling two six sided dice and adding their values, then the resulting value is searched on the first column, and the event from the second column is applied to the game.

[interval_javadoc]: ./apidocs/com/wandrell/tabletop/interval/Interval.html
[intervals_table_javadoc]: ./apidocs/com/wandrell/tabletop/interval/table/IntervalsTable.html

[interval_interface]: ./images/interval.png
[intervals_table_interface]: ./images/intervals_table.png