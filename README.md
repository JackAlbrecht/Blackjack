# Blackjack
Blackjack is a program to demonstrate Stacks and Queues. This allows us to deal, shuffle, count, and get a value for each card in the customary fashion of blackjack.

This program uses 3 classes:
- BlackjackGame: This is where the game operations are performed including the dealing, hitting/standing, and winning/losing.
- Card: This creates a string with the values of rank and suit to identify cards and use them within the program.
- Deck: This is where the cards are stored and shuffled, and this is also where the cards are created by pulling from the top of the deck using a stack (LIFO).
- Hand: This is where hands are stored and where the value of your hand is calculated, we add cards to the hand using a queue (FIFO) to make sure we only pull the amount of cards desired.

Using these classes and stacks/queues we are able to create a fully functioning game where the cards are pulled from the deck and put into your hand, and the dealers hand, in a Blackjack fashion.

Thank you for checking out my program, 

If you have questions please reach out at: Jackalbrecht5@gmail.com

---------------------------------------------------------------------------------------------------------------------------------
This program is a Computer Science 2 (CS145) project for Prof. Darrell Criss at Whatcom Community College, Spring 2023.

The formal assignment name is "Lab 4: Deck of Cards".
