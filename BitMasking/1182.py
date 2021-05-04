import sys

N,S = map(int,sys.stdin.readline().split())
li = list(map(int,sys.stdin.readline().split()))
bits = list(0 for i in range(N))
ans = 0
def recur(idx):
    global bits, li, ans
    if idx == N:
        tmp = 0
        cnt = 0
        for i in range(len(bits)):
            if bits[i]:
                tmp += li[i]
                cnt += 1
        if tmp == S and cnt>0:
            ans += 1
        return
    recur(idx+1)
    bits[idx] = ~bits[idx]
    recur(idx+1)

recur(0)
print(ans)
