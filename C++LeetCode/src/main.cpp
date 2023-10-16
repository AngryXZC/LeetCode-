#include <iostream>
#include <vector>

using namespace std;

vector<int> singleNumber(vector<int> &nums)
{
	int xor_result = 0;
	for (int num : nums)
	{
		xor_result ^= num;
	}

	int mask = 1;
	while ((xor_result & mask) == 0)
	{
		mask <<= 1;
	}

	int a = 0, b = 0;
	for (int num : nums)
	{
		if ((num & mask) != 0)
		{
			a ^= num;
		}
		else
		{
			b ^= num;
		}
	}

	return {a, b};
}

int main()
{
	vector<int> nums = {1, 2, 3, 2, 1, 4, 5};
	vector<int> res = singleNumber(nums);

	cout << res[0] << " " << res[1] << endl;

	return 0;
}