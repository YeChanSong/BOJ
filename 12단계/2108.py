import sys, collections

n = int(sys.stdin.readline().strip())
tmp = []

for i in range(n):
    tmp.append(int(sys.stdin.readline().strip()))
cntr = collections.Counter(sorted(tmp))
cntr = cntr.most_common()
avg = round(sum(tmp)/n)
tmp.sort()
mid = tmp[n//2]
if len(cntr) >1:
    a = cntr[0]
    b = cntr[1]
    if a[1] == b[1]:
        mny = b[0]
    else:
        mny = a[0]
else:
    mny = cntr[0][0]
rng = tmp[-1] - tmp[0]

print(avg)
print(mid)
print(mny)
print(rng)