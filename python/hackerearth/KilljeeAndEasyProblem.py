def dfs(graph, visited, result, node):
    if visited[node]:
        return

    result.append(str(node))
    visited[node] = True
    for n in graph[node]:
        if visited[n]:
            continue
        dfs(graph, visited, result, n)
        result.append(str(node))


def main():
    n, m = [int(x) for x in input().split()]
    graph = [[] for _ in range(n+1)]
    for i in range(m):
        n1, n2 = [int(x) for x in input().split()]
        graph[n1].append(n2)
        graph[n2].append(n1)
    result = []
    visited = [False] * (n+1)
    dfs(graph, visited, result, 1)
    print(len(result))
    print(' '.join(result))


if __name__ == '__main__':
    main()
