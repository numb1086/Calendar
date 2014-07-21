=============================Calendar=============================

/****************************Steps***************************/

1.Input year and month

2.Establish an object to create a calendar

3.Print out the calendar

/**********************************************************/

/********************Method Analysis***********************/

1.getCalendar()

  ->Judge if the format of month is right.

    ->If the year is leap year,the February day plus 1.
    
    ->Find the sapce day of each month in that year.

    ->Send the space day and month day to the show() method
 
      to print the calendar.

  ->If the format is wrong,the console will show error message.

2.isLeapYear()

  ->Judge if the year is leap year.

    ->if the year can be divided by 4 and 400 or can't divided
 
      by 100,it is a leap year.

3.show()

  ->Use the space day and month day to print out the calendar.


/**************************Reference**************************/
http://blog.yam.com/ewestein/article/16667621
http://lawlietmoon.pixnet.net/blog/post/33526335-%E8%90%AC%E5%B9%B4%E6%9B%86(%E5%A4%A7%E5%A6%B9%E4%BD%9C%E6%A5%AD)
