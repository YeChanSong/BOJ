import sys
a = []
for i in range(3):
    a.append(int(sys.stdin.readline().strip()))
mul = str(a[0] * a[1] * a[2])
cnt = [0 for i in range(10)]
for i in mul:
    cnt[int(i)] += 1
for i in cnt:
    print(i)
