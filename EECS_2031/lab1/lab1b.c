/***************************************
 * EECS2031 – Lab 1 				   *
 * Filename: lab1b.c 	               *
 * Author: AHMAD, AAMIR  	           *
 * Email: aamirsa@my.yorku.ca          *
* EECS/CSE number: *********		   *
 ****************************************/

#include <stdio.h>

main()
{
	printf("Enter a line of characters>");
	char c;
	int counter = 0;
	while ((c = getchar()) != '\n')
	{
		if (c == '\t' || c == ' ')
			counter++;
	}
	printf("%d\n", counter);
	return 0;
}
