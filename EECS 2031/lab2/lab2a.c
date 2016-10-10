#include <stdio.h>

int main(int argc, char const *argv[])
{
	int c, counter, sum;
	while ((c = getchar()) != '\n')
	{
		if (c >= 48 && c <= 57)
		{
			counter++;
			c -= 48;
			sum += c;
		}
	}
	printf("%d\t%d\n", counter, sum);
	return 0;
}