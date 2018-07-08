input()
a = input().split()
print(max(sorted(a), key=a.count))
