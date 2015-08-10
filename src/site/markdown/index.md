# Tabletop intervals

Intervals are commonly used on tabletop games, usually as a way to map ranges of values to an specific result.

The most simple example of this is having two consecutive intervals, one marking the range for success and the other for failure, which will be compared to the result of a dice roll. If the dice value falls on the first interval, it was a success, if it falls on the second it was a failure.

Of course, things can get more complex than this, it is common having a big interval divided into smaller ones, each having a different result assigned, creating what is basically a mapped table of intervals.

This project is meant to handle such situations, by offering an API and default implementations both for both the basic and the more complex types of intervals.

## Features

The library supports the following types of intervals:

- Basic interval
- Interval table

Additionally, it offers the following utilities classes:

- Utilities class for interval operations