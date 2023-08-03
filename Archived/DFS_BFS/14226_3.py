import sys, collections

S = int(sys.stdin.readline().strip())
cache = list([-1 for _ in range(1001)] for _ in range(1001))
# cache[이모티콘 수][클립보드 이모티콘 수]
q = collections.deque()
q.append((1,0)); cache[1][0] = 0
# itm = (이모티콘 수, 클립보드 이모티콘 수)
while q:
    itm = q.popleft()
    
    if itm[0] == S:
        # 미리 캐시에 값을 넣기 때문에 S값이 나오자 마자 멈출 수 있다.
        break
    # 복사
    if itm[0]!=itm[1] and cache[itm[0]][itm[0]] == -1:
        q.append((itm[0],itm[0]))
        cache[itm[0]][itm[0]] = cache[itm[0]][itm[1]] +1
    # 붙여넣기
    if itm[1] != 0 and itm[0]+itm[1]<=S and cache[itm[0]+itm[1]][itm[1]] == -1:
        q.append((itm[0]+itm[1],itm[1]))
        cache[itm[0]+itm[1]][itm[1]] = cache[itm[0]][itm[1]] +1
    # 1개 삭제
    if itm[0]>2 and cache[itm[0]-1][itm[1]] == -1:
        q.append((itm[0]-1,itm[1]))
        cache[itm[0]-1][itm[1]] = cache[itm[0]][itm[1]] +1
mn = 100000
for i in cache[S]:
    if i == -1:
        continue
    mn = min(mn,i)
print(mn)