#include <stdio.h>

#define MAX_SIZE 100

int main()
{
  char c;
  char a[MAX_SIZE]; // string
  int my_int;
  ///// your code /////
  int i = 0, j;
  while ( (c = getchar()) != '\n' )
  {
    a[i++] = c - 48;
  }

  my_int = 0;
  for (int j = 0; j < i; j++)
    my_int =  a[j] + (my_int * 10);


  printf("%6d\n", my_int);
  return 0;
}