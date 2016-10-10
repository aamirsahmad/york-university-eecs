#include <stdio.h>

int main()
{
	int arr[100];
	int input;
	int max, min, i;
	max = min = i = 0;
	arr[99] = 0;

	while (1)
	{
		printf("%s", "Enter the next array element>");
		scanf("%d", &input);
		if (input == 0)
		{
			break;
		}
		arr[i++] = input;
		if (input > max)
		{
			max = input;
		}
		if (input < min)
		{
			min = input;
		}
	}
	printf("%d\t%d\n", max, min);
	return 0;
}