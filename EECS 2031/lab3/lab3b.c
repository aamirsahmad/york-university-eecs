#include <stdio.h>

#define MAX_SIZE 100

int main() {

  char my_strg[ MAX_SIZE ];   /* to store the octal number in the form of an array of char */
  int my_int;
  char c;
  int i = 0, isOctal = 1, isNegative = 0;
  while ( (c = getchar()) != '\n' )
  {
    if (c == '-')
      isNegative = 1;
    else if ((c - 48) > 7)
      isOctal = 0;
    else
      my_strg[i++] = c - 48;
  }

  if (!isOctal)
  {
    printf("%s\n", "Error: not an octal number");
  }
  else
  {
    my_int = 0;
    for (int j = 0; j < i; j++)
      my_int =  my_strg[j] + (my_int * 8);
    if (isNegative) my_int *= -1;
    printf( "%10d\n", my_int );  /* output the decimal integer */
  }
}
