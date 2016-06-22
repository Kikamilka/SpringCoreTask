CounterAspect - count how many times each event was accessed by name, how many times its prices were queried, how many times its tickets were booked. Store counters in map for now (later could be replaced by DB dao)

DiscountAspect - count how many times each discount was given total and for specific user

LuckyWinnerAspect - every time the bookTicket method is executed perform the checkLucky method for the user that based on some randomness will return true or false. If user is lucky, the ticketPrice changes to zero and ticket is booked, thus user pays nothing.
