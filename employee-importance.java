/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees)
            map.put(e.id, e);
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        int impo = 0;
        while (q.size() > 0) {
            Employee cur = q.poll();
            impo += cur.importance;
            for (int s : cur.subordinates)
                q.add(map.get(s));
        }
        return impo;
    }
}
​
