#include <stdio.h>

int fibonacci(int n)
{
	_Pragma("ASPIRE begin protection(remote_attestation, static_ra_region, attestator(first_attestator), attest_at_startup(false))")
	_Pragma("ASPIRE end")
	_Pragma("ASPIRE begin protection(remote_attestation, static_ra(RW_NORMAL, HF_SHA256, NI_3, NG_1, MA_1, DS_1), label(first_attestator), frequency(10))")
	int last, before;
	int tmp;
	int i;

	for (i = 0; i < n; ++i)
	{
		tmp = last;
		if (i == 0)
			last = 0;
		else if (i == 1)
			last = 1;
		else
			last = last + before;
		before = tmp;
	}

	return last;
	_Pragma("ASPIRE end")
}

int main()
{
	_Pragma("ASPIRE begin requirement(integrity, confidentiality)")
	int i __attribute__((ASPIRE("requirement (confidentiality)")));

	for (i = 1; i <= 10; ++i)
		printf("%d\n", fibonacci(i));

	return 0;
	_Pragma("ASPIRE end")
}
