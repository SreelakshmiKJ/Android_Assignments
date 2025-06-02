#include <iostream>
#include <vector>
using namespace std;

bool detectCycle(int curr, const vector<vector<int>> &graph, vector<bool> &visited, vector<bool> &inPath)
{
    visited[curr] = true; // marks if a node has ever visited
    inPath[curr] = true;  // keeps track of current dfs path helps to detect cycle (recursion)

    for (int next : graph[curr]) // explore all neighbours of curr node
    {
        if (!visited[next])
        {
            if (detectCycle(next, graph, visited, inPath))
                return true; // If any deeper call finds a cycle, return true
        }
        else if (inPath[next])
        {
            return true; // Found a back edge, hence a cycle
        }
    }

    inPath[curr] = false;
    return false;
}

bool hasCircularDependency(int numModules, vector<vector<int>> &dependencies)
{
    vector<vector<int>> graph(numModules); // prepare the graph and run dfs from all nodes
    for (const auto &dep : dependencies)
    {
        graph[dep[0]].push_back(dep[1]); // dep[0] depends on dep[1]
    }

    vector<bool> visited(numModules, false);
    vector<bool> inPath(numModules, false);

    for (int module = 0; module < numModules; ++module)
    {
        if (!visited[module])
        {
            if (detectCycle(module, graph, visited, inPath))
                return true;
        }
    }

    return false;
}

// Demonstration
int main()
{
    int n, m;
    cout << "Enter number of modules: ";
    cin >> n;

    cout << "Enter number of dependencies: ";
    cin >> m;

    vector<vector<int>> deps;
    cout << "Enter dependencies in the format a b (a depends on b):\n";
    for (int i = 0; i < m; ++i)
    {
        int a, b;
        cin >> a >> b;
        deps.push_back({a, b});
    }

    if (hasCircularDependency(n, deps))
    {
        cout << "true\n";
    }
    else
    {
        cout << "false\n";
    }

    return 0;
}
