/***************************************
* EECS2031 – Lab 1 					   *
* Filename: lab1a.c 	               *
* Author: AHMAD, AAMIR  	           *
* Email: aamirsa@my.yorku.ca           *
* EECS/CSE number: *********		   *
****************************************/

#include <stdio.h>

int main()
{
	float inches;
	while (1)
	{
		printf("%s", "Enter the measurement in inches>");
		scanf("%f", &inches);
		if (inches == 0)
		{
			break;
		}
		else
		{
			float centimeters = inches * 2.54;
			printf("%.2f cm\n", centimeters);
		}

	}
	return 0;
}
