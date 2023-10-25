
import 'dart:io';

void  main()
{
  print("You have to write a factorial number:");
  int number = int.parse( stdin.readLineSync().toString() );
  BigInt sum = BigInt.from(1);

  for (int i = 1; i <= number; i++)
    sum *= BigInt.from(i);
  print("\nResult is $sum");
}