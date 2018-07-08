"""
https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/the-wealthy-landlord/description/
"""


class Query:
    def __init__(self, x1, y1, x2, y2, cost):
        self.x1 = x1
        self.y1 = y1
        self.x2 = x2
        self.y2 = y2
        self.cost = cost


def parse_query(line):
    lst = list(map(int, line.split()))
    return Query(*lst)


x_max = -1
y_max = -1
queries = []
for _ in range(int(input())):
    query = parse_query(input())
    queries.append(query)
    x_max = max(x_max, query.x1)
    x_max = max(x_max, query.x2)
    y_max = max(y_max, query.y1)
    y_max = max(y_max, query.y2)

x_max += 1
y_max += 1

total_land = [[0] * y_max for _ in range(x_max)]
for query in queries:
    for x in range(query.x1, query.x2+1):
        for y in range(query.y1, query.y2+1):
            if total_land[x][y] == 0:
                total_land[x][y] = query.cost
            elif total_land[x][y] > 0:
                total_land[x][y] = -(total_land[x][y] + query.cost)
            else:
                total_land[x][y] -= query.cost

ans = 0
for row in total_land:
    ans += sum(filter(lambda i: i < 0, row))

print(-ans)
