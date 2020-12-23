import sys

n = int(sys.stdin.readline().strip())
nums = list(i for i in range(1,n+1))
stack = []
ans = []
tmp = 0
flag = True
for i in range(n):
    num = int(sys.stdin.readline().strip())
    while 1:
        if tmp == n or nums[tmp] > num:
            break
        stack.append(nums[tmp])
        ans.append('+')
        tmp += 1
    
    if len(stack) == 0 or stack[-1] > num:
        flag = False
        break
    
    while 1:
        if len(stack) == 0 or stack[-1] < num:
            break
        stack.pop()
        ans.append('-')
        
    
        
if flag == False:
    print("NO")
else:
    for i in ans:
        print(i)
    
    