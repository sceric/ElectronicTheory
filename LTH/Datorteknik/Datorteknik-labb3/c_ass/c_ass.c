/* 
 *  Laboratory Exercise 3, Assignment 4
 *  Written by Jan Eric Larsson, 5 November 1998
 *
 */

int Test[10] = { 1, 3, 5, 7, 9, 8, 6, 4, 2, 0 };

int FindMaxC(int Value[])
{
  int n, Max;

  Max = Value[0];
  for (n = 1; n < 10; n = n + 1) {
    if (Value[n] > Max) Max = Value[n];
  }
  return Max;
}

main ()
{
  printf("Lab 3, Assignment 4\n");
  printf("The max is %d\n", FindMaxC(Test));
  printf("Done\n");	
}

