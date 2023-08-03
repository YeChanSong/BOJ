import sys

K = int(sys.stdin.readline().strip())
stack = list()

for i in range(K):
    cmd = int(sys.stdin.readline().strip())
    if cmd == 0:
        stack.pop()
    else:
        stack.append(cmd)
print(sum(stack))
