import 'dart:io';

int count_primers = 0;

bool control(int count)
{
  for (int i = 2; i < count; i++)
    if (count % i == 0)
      return (false);
  count_primers += 1;
  return (true);
}
void  main()
{
  print("You can write a number:");
  int number = int.parse( stdin.readLineSync().toString() );

  if (number < 0)
  {
    print("No negative number");
    return ;
  }

  print("\nPrimers:");
  for (int i = 2; i < number; i++)
    if (control(i) == true)
    {
      print("$i ");
    }
  print("\nHow many primers $count_primers");
}