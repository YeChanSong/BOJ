import sys

n = list(sys.stdin.readline().strip())
print(int(''.join(sorted(n,reverse=True))))