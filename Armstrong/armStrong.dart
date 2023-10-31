
import 'dart:io';
import 'dart:math';
void main()
{
  int number = int.parse( stdin.readLineSync().toString() );
  int base = 0;
  int sum = 0;
  int tmp;

  for (tmp = number; tmp > 0; base += 1)
    tmp ~/= 10;
  tmp = number;
  for (int i = base; i > 0; i--)
  {
    sum += pow(number % 10, base).toInt();
    number ~/= 10;
  }
  if (tmp == sum)
    print("it's a Armstrong number");
  else
    print("it is not a Armstrong number");
}