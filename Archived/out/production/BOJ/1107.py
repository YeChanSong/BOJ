import sys

N = sys.stdin.readline().strip()
M = int(sys.stdin.readline().strip())
ban = set()
if M:
    ban = set(map(int,sys.stdin.readline().strip().split()))
nums = set([0,1,2,3,4,5,6,7,8,9])
pm = abs(100-int(N))
ex = sorted(nums - ban)
cnt = 10**300
for i in range(int(N),1000000):
    chk = str(i)
    flag = True
    for j in chk:
        if int(j) not in ex:
            flag = False
    if flag:
        cnt = min(cnt, len(chk)+ i -int(N))
        break
for i in range(int(N)-1,-1,-1):
    chk = str(i)
    flag = True
    for j in chk:
        if int(j) not in ex:
            flag = False
    if flag:
        cnt = min(cnt, len(chk)+int(N)-i)

if ex:
    print(min(pm,cnt))
else:
    print(pm)