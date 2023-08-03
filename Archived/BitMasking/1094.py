import sys

x = int(sys.stdin.readline().strip())
l = 64
ans = 0

while 1:
    if x==0:
        break        
    if l <= x:
        ans |=l
        x &= ~l
    l>>=1

ans = bin(ans)
cnt = 0
for i in ans:
    if i == '1':
        cnt += 1
print(cnt)
