#include <stdio.h>

#define MAX_SIZE 100

int main() {

   char my_strg[ MAX_SIZE ];

   // Input and add characters to array
   char c;
   int i = 0;
   while ((c = getchar()) != '\n')
   {
      my_strg[i++] = c;
   }
   my_strg[i] = '\0';

   // Reverse
   int j = 0;
   i--;
   while (j < i)
   {
      char temp = my_strg[j];
      my_strg[j] = my_strg[i];
      my_strg[i] = temp;
      j++;
      i--;
   }

   // Print reversed string
   printf( "%s\n", my_strg );  /* output the reversed string */
}
