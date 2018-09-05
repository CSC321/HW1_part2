# HW1 part 2

For the second part of this assignment, you are to organize the output so that all of the valid sequences are displayed together (with heading VALID), followed by all of the invalid sequences (with heading INVALID). Within each category, the sequences should be displayed in increasing numerical order (ignoring any non-digits).

You should also augment your program so that it can handle sequences in which a single digit has been corrupted. That is, the character '?' may appear in a sequence in the place of an unknown digit. Because of the check number, it should be possible to determine the value of the missing digit. Augment your program so that it determines the missing digit and adds the corresponding sequence to the list of valid sequences. Note: any code that contains more than one '?' is considered invalid.