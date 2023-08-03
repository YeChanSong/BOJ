import sys

N = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().strip().split()))
ans = -1000
idx = 0
tmp = 0
while 1:
    if idx == N:
        break
    # 최댓값을 구하는 문제 이므로 더해나가는 숫자가 0보다 작아져서 합이 작아지는 그림이 나오면 안된다.
    # 따라서 idx까지의 수를 더한 tmp가 0보다 작아지면 0으로 초기화해준다.
    tmp += li[idx]
    if tmp > ans:
        # 기존까지의 최댓값을 보유한 ans 보다 tmp가 더 커진다면, ans를 갱신해준다.
        ans = tmp
    if tmp < 0:
        tmp = 0
    idx +=1
        
print(ans)

'''
이중 리스트로 캐시 작성시 메모리 초과
아래 코드로 캐시 작성시 시간 초과

import sys

N = int(sys.stdin.readline().strip())
cache = list(map(int,sys.stdin.readline().strip().split()))
li = cache.copy()
ans = max(cache)
for i in range(1,N):
    for j in range(N-i):
        cache[j] = li[j] + cache[j+1]
        if cache[j] > ans:
            ans = cache[j]
print(ans)
'''
