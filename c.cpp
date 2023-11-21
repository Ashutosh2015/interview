#include <iostream>
#include <string>

using namespace std;

string findSmallestUnit(const string &multigram)
{
      string smallestUnit = multigram;

      for (int i = 1; i < multigram.length(); ++i)
      {
            string unit = multigram.substr(0, i);
            int j = i;

            while (j < multigram.length() && multigram.substr(j, i) == unit)
            {
                  j += i;
            }

            if (j == multigram.length() && multigram.length() % i == 0)
            {
                  smallestUnit = unit;
                  break;
            }
      }

      return smallestUnit;
}

int main()
{
      string multigram;

      // Input multigram from the user
      cout << "Enter a multigram: ";
      cin >> multigram;

      // Find the smallest unit
      string smallestUnit = findSmallestUnit(multigram);

      // Output the result
      cout << "Smallest unit of the multigram: " << smallestUnit << endl;

      return 0;
}
